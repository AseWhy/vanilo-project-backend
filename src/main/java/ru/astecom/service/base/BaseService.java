package ru.astecom.service.base;

import io.github.asewhy.conversions.ConversionMutator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.exceptions.base.CustomException;
import ru.astecom.models.base.iIdentifiable;
import ru.astecom.models.base.iUserContains;
import ru.astecom.secure.Helper;

import java.util.*;

@SuppressWarnings({"SameParameterValue", "OptionalUsedAsFieldOrParameterType", "unused"})
public class BaseService<E extends iIdentifiable<ID>, ID, R extends JpaRepository<E, ID>> {
    @Autowired
    protected R repository;
    protected final Class<E> type;
    protected final Set<Class<?>> interfaces;

    /**
     * Базовый сервис данных
     *
     * @param type тип данных сервиса
     */
    public BaseService(@NotNull Class<E> type) {
        this.type = type;
        this.interfaces = Set.of(type.getInterfaces());
    }

    /**
     * Найти сущность по её идентификатору
     *
     * @param id идентификатор сущности
     * @return найденная сущность
     */
    public E findById(ID id) {
        return validateNotFound(repository.findById(id), "id", id);
    }

    /**
     * Найти сущность по идентификатору с проверкой владельца
     *
     * @param id идентификатор сущности
     * @return найденная сущность
     */
    public E restFindById(ID id) {
        return validateOwner(findById(id), "id", id);
    }

    /**
     * Проверить владельца сущности на соответствие текущему пользователю
     *
     * @param found найденная сущность
     * @param keyName имя ключа поиска
     * @param id идентификатор поиска
     * @return найденная сущности
     */
    protected E validateOwner(E found, String keyName, Object id) {
        var invoker = Helper.getPresentInvoker();

        if(found instanceof iUserContains uc && !Objects.equals(invoker.getId(), uc.getUserId())) {
            throw accessDenied(type, id, keyName);
        }

        return found;
    }

    /**
     * Проверяет, доступна ли сущность
     *
     * @param found то что было найдено
     * @param id идентификатор
     * @return сущность, если была найдена и должна быть распакована.
     */
    protected E validateNotFound(@NotNull Optional<E> found, String keyName, Object id) {
        return validateNotFound(this.type, found, keyName, id);
    }

    /**
     * Проверяет, доступна ли сущность
     *
     * @param found то что было найдено
     * @param id идентификатор
     * @return сущность, если была найдена и должна быть распакована.
     */
    protected <T> T validateNotFound(Class<T> type, @NotNull Optional<T> found, String keyName, Object id) {
        if(found.isPresent()) {
            return found.get();
        } else {
            throw this.cannotFind(type, id, keyName);
        }
    }

    /**
     * Ошибка: невозможно найти сущность по ключу
     *
     * @param id значение ключа
     * @param keyName название ключа
     */
    protected RuntimeException cannotFind(Object id, String keyName) {
        return cannotFind(this.type, id, keyName);
    }

    /**
     * Ошибка: невозможно найти сущность по ключу
     *
     * @param id значение ключа
     * @param keyName название ключа
     */
    protected RuntimeException cannotFind(Class<?> type, Object id, String keyName) {
        return new CustomException("Cannot find " + type.getSimpleName() + " on [" + keyName + " = " + id + "].", HttpStatus.NOT_FOUND);
    }

    /**
     * Ошибка: доступ запрещен
     *
     * @param id значение ключа
     * @param keyName название ключа
     */
    protected RuntimeException accessDenied(Class<?> type, Object id, String keyName) {
        return new CustomException("You cannot access " + type.getSimpleName() + " on [" + keyName + " = " + id + "].", HttpStatus.FORBIDDEN);
    }

    /**
     * Получить страницу по фильтру сущностей
     *
     * @param filter фильтр для поиска
     * @return найденная страница
     */
    public RestPage<E> list(@NotNull NoodleRestFilter filter) {
        return filter.build(type);
    }

    /**
     * Получить страницу по фильтру сущностей
     *
     * @param filter фильтр для поиска
     * @return найденная страница
     */
    public RestPage<E> restList(@NotNull NoodleRestFilter filter) {
        var invoker = Helper.getInvokerNullable();

        if(this.interfaces.contains(iUserContains.class)) {
            if(invoker != null) {
                filter.and(condition -> condition.where("userId", invoker.getId()));
            } else {
                filter.and(condition -> condition.where("userId", "is null", null));
            }
        }

        return list(filter);
    }

    /**
     * Удаляет сущность
     *
     * @param entity сущность для удаления
     * @return возвращает удаленную сущность
     */
    public E hardDelete(E entity) {
        repository.delete(entity); return entity;
    }

    /**
     * Удаляет сущность по идентификатору
     *
     * @param id ид сущности для удаления
     * @return возвращает удаленную сущность
     */
    public E hardDelete(ID id) {
        return hardDelete(findById(id));
    }

    /**
     * Удаляет сущность по идентификатору
     *
     * @param id ид сущности для удаления
     * @return возвращает удаленную сущность
     */
    public E restDeleteById(ID id) {
        return hardDelete(restFindById(id));
    }

    /**
     * Сохраняет сущность
     *
     * @param target целевая сущность для сохранения
     * @return сохраненные сущности
     */
    public <C extends E> C save(C target) {
        return repository.save(target);
    }

    /**
     * Сохраняет сущность
     *
     * @param targets целевые сущности для сохранения
     * @return сохраненные сущности
     */
    public List<E> save(Collection<E> targets) {
        return repository.saveAll(targets);
    }

    /**
     * Создает новую сущность
     *
     * @param mutator мутатор переданный в запросе
     * @return сохраненная сущность
     */
    public E insert(@NotNull ConversionMutator<E> mutator) {
        try {
            return save(mutator.fill(type.getConstructor().newInstance()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Создает новую сущность, или сохраняет текущую
     *
     * @param id идентификатор сущности для обновления или сохранения
     * @param mutator мутатор переданный в запросе
     * @return сохраненные сущность
     */
    public E updateOrInsert(ID id, ConversionMutator<E> mutator) {
        if(id != null) {
            var found = repository.findById(id);

            if (found.isPresent()) {
                return save(mutator.fill(found.get()));
            } else {
                return insert(mutator);
            }
        } else {
            return insert(mutator);
        }
    }
}
