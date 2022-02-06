INSERT INTO public.users (id, login, "password", first_name, last_name, date_of_birth, phone, email) VALUES(1, 'astecom@mail.ru', '$2a$10$xRmHFscp57DUIrVuNdu9nOgVDh14v5PsqRPFVDOqWB50Ryd4D0Ny2', 'Алексей', 'Плеханов', '2002-06-21', NULL, 'astecom@mail.ru');

ALTER SEQUENCE users_id_seq RESTART WITH 2;

--
-- ADD AUTHORS
--

INSERT INTO public.authors (id, name) VALUES (1, 'Tyler, The Creator');
INSERT INTO public.authors (id, name) VALUES (2, 'The Weeknd');
INSERT INTO public.authors (id, name) VALUES (3, 'Travis scott');
INSERT INTO public.authors (id, name) VALUES (4, 'Kendrick lamar');
INSERT INTO public.authors (id, name) VALUES (5, 'Kanye west');
INSERT INTO public.authors (id, name) VALUES (6, 'Xxxtentacion');
INSERT INTO public.authors (id, name) VALUES (7, 'Mac Miller');
INSERT INTO public.authors (id, name) VALUES (8, 'Linkin Park');
INSERT INTO public.authors (id, name) VALUES (9, 'Beatles');
INSERT INTO public.authors (id, name) VALUES (10, 'Lil Peep');
INSERT INTO public.authors (id, name) VALUES (11, 'Billie Eilish');
INSERT INTO public.authors (id, name) VALUES (12, 'Lana Del Rey');
INSERT INTO public.authors (id, name) VALUES (13, 'Kaleo');

ALTER SEQUENCE authors_id_seq RESTART WITH 14;

--
-- ADD COLLECTIONS
--

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    1,
    'En',
    true,
    'Igor',
    E'Igor is a 2019 studio album by American rapper Tyler, The Creator. The album is a mosaic of humming bass lines, prominent keyboard breaks and out-of-tune synths.',
    49.9,
    '0190759652213',
    'tyler_0.png',
    '2019-01-01',
    1,
    'Columbia',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    2,
    'En',
    true,
    'The Highlights',
    E'"The Highlights" is a collection of the best songs by The Weeknd.',
    49.9,
    '0602435931975',
    'weeknd_0.png',
    '2021-01-01',
    2,
    'Republic',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    3,
    'En',
    true,
    'Astroworld',
    E'Astroworld is the third studio album by Travis Scott, which was released on physical media in September 2018.\r\n\r\nReleased digitally in early August via Grand Hustle Records, Epic Records and Cactus Jack Records, the album received many (mostly positive) reviews from The Independent, NME, Exclaim!, Rolling Stone and more. It follows Travis\' second studio album "Birds in the Trap Sing McKnight" (2016), as well as the 2017 collaboration with rapper Quavo "Huncho Jack, Jack Huncho".\r\n\r\nOn the new album, as usual, Travis features many stellar guest vocalists, including Kid Cudi, Frank Ocean, Drake, The Weeknd, James Blake, Swae Lee, Gunna, Nav, 21 Savage, Quavo, Takeoff, Juice Wrld, Sheck Wes and Don Toliver . Travis also traditionally did not limit himself to working with one producer. The album features an entire production team including Mike Dean, Allen Ritter, Hit-Boy, WondaGurl, Tay Keith, Tame Impala, Frank Dukes, Sonny Digital and Thundercat.',
    49.9,
    '0190758883618',
    'travis_0.png',
    '2018-01-01',
    3,
    'Epic / Cactus Jack / Grand',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    4,
    'En',
    true,
    'To Pimp A Butterfly',
    E'To Pimp a Butterfly is the third studio album by American rapper Kendrick Lamar, released on March 15, 2015 by Top Dawg, Aftermath Entertainment and Interscope Records. The producer was Dr. Dre and others. Lamar\'s disc topped the US Billboard 200 and was also nominated for a 2016 Grammy Award in the Best Album of the Year category.',
    49.9,
    '0602547300683',
    'kendrick_0.png',
    '2015-01-01',
    4,
    'Top Dawg Entertainment',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    5,
    'En',
    true,
    'Ye',
    E'Ye is the eighth solo studio album by American hip hop musician and producer Kanye West, released on June 1, 2018 by GOOD Music and Def Jam. The recording of the album was attended by such musicians as Ty Dolla Sign, PartyNextDoor, Kid Cudi, Jeremih, 070 Shake, Charlie Wilson, Nicki Minaj and others. The album was produced by West himself with Mike Dean as co-producer. Ye debuted at number one on the US Billboard 200, becoming West\'s eighth career top chart topper.',
    49.9,
    '0602547300683',
    'kanye_0.png',
    '2018-01-01',
    5,
    'Roc-A-Fella Records',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    6,
    'En',
    true,
    'Skins',
    E'Skins is the third studio album by American rapper XXXTentacion, released on December 7, 2018.',
    49.9,
    '0888915777138',
    'xxxtentacion_0.png',
    '2018-01-01',
    6,
     'Label: Bad Vibes Forever.',
     'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    7,
    'En',
    true,
    'Swimming in circles',
    E'Today, the Mac Miller family announced the release of the "Swimming In Circles" four-disc vinyl box set, consisting of the "Swimming" and "Circles" albums. These are the artist\'s last two releases; they were conceived as companion albums and are now being released as part of a deluxe set. Along with the announcement, the musician\'s heirs released unreleased footage from the studio sessions for "Swimming" and "Circles". The box set comes out December 18, 2020.\r\n\r\n"Circles" was released in January of this year and broke the record for Apple Music pre-orders. It peaked at number three on the Billboard 200, becoming Miller\'s sixth album to debut in the top 5 of the chart. Circles is one of the most likely candidates for Grammy nominations (including Album of the Year, Record of the Year, and Song of the Year). Mac Miller\'s previous work "Swimming" was nominated for a Grammy in the Best Rap Album category. Miller did not have time to finish "Circles": it was completed by producer Jon Brion, with whom the musician also worked on "Swimming".',
    49.9,
    '0093624892106',
    'mac_0.png',
    '2020-01-01',
    7,
     'Warner Music',
     'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    8,
    'En',
    true,
    'Late registration',
    E'Late Registration is the second studio album by American rapper Kanye West, released on August 30, 2005. The album was recorded over the course of a year at various studios in New York and Hollywood. During the recording, West collaborated with producer Jon Brion. The album features Jay-Z, Lupe Fiasco, Jamie Foxx, Nas, Brandy and Adam Levine of Maroon 5.',
    49.9,
    '0602498824047',
    'kanye_1.png',
    '2018-01-01',
    5,
     'Roc-A-Fella Records',
     'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    9,
    'En',
    true,
    'Meteora (2 LP)',
    E'Meteora is the second studio album by Linkin Park, released on March 25, 2003. It became the most successful album in the history of the Modern Rock Tracks chart, which specializes in radio rotation of alternative rock songs. "Numb" became, according to the results of the chart, the song of the year. The album has sold 6 million copies in the US and over 20 million worldwide. The instrumental track "Session" was nominated for a Grammy for Best Rock Instrumental Performance in 2003. The album was the last released in the genre of nu metal and alternative metal.\r\n\r\nMost of the songs for this work were written in the summer of 2001 at the Ozzfest heavy music festival. By the time the musicians moved into the studio to record material, they had 30 complete songs, 18 of which were subsequently screened out',
    49.9,
    '0093624915959',
    'linkin_0.png',
    '2016-01-01',
    8,
     'Interscope Records.',
     'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    10,
    'En',
    true,
    'Abbey road',
    E'Abbey road is the second studio album by Linkin Park, released on March 25, 2003. It became the most successful album in the history of the Modern Rock Tracks chart, which specializes in radio rotation of alternative rock songs. "Numb" became, according to the results of the chart, the song of the year. The album has sold 6 million copies in the US and over 20 million worldwide. The instrumental track "Session" was nominated for a Grammy for Best Rock Instrumental Performance in 2003. The album was the last released in the genre of nu metal and alternative metal.\r\n\r\nMost of the songs for this work were written in the summer of 2001 at the Ozzfest heavy music festival. By the time the musicians moved into the studio to record material, they had 30 complete songs, 18 of which were subsequently screened out',
    49.9,
    '0602508007446',
    'beatles_0.png',
    '2019-01-01',
    9,
     'Machine Shop Recordings',
     'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    11,
    'En',
    true,
    E'Come over when you\'re sober',
    E'In November 2017, Gustav Ara, better known as Lil Peep, passed away. He died at twenty-one while working on the sequel to his first album Come Over When You\'re Sober Part 1. After the death of the rapper, his team stated that they would release this album when the time was right. And it seems that the time has come to fulfill the promise.',
    49.9,
    '0190758933719',
    'peep_0.png',
    '2018-01-01',
    10,
    'Columbia / AUTNMY',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    12,
    'En',
    true,
    'When we all fall',
    E'When We All Fall Asleep, Where Do We Go? is the debut studio album by American singer-songwriter Billie Eilish, released on March 29, 2019 by Darkroom and Interscope Records. Most of the songs were written during the preparation of the mini-album Don\'t Smile at Me (2017). The compositions were supposed to be part of a studio album, which was supposed to be released in 2017, however, the Don\'t Smile at Me mini-album was released instead.',
    49.9,
    '0602577427664',
    'eilish_0_0.png',
    '2019-01-01',
    11,
    'Interscope Records / Darkroom',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    13,
    'En',
    true,
    'Born to die',
    E'Born to Die is Lana Del Rey\'s second studio album, released on January 27, 2012 via Interscope, Polydor and Stranger Records. The singer worked on it in a team with producers such as Emil Haney, Patrick Berger, Chris Bride, Rick Knowles, Roboopop, Al Shooks, Jeff Bhasker and Justin Parker. The album\'s compositions are designed in the genres of alternative music, baroque pop, indie pop, trip-hop and rock.\r\n\r\nThe album debuted at number two on the Billboard 200. The album peaked at the top of the charts in eleven countries. Worldwide, as of 2015, it sold about 8.5 million copies. The album was included in the list of the best discs12 of a dozen different publications2, Drowned in Sound, The Guardian, NME and others named it one of the "20 Best Albums of the 2010s" by Billboard magazine.',
    49.9,
    '602527934242',
    'lana_0.png',
    '2012-01-01',
    12,
    'Interscope Records',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    14,
    'En',
    true,
    'Surface sounds',
    E'Anniversary extended re-release of the Abbey Road album, timed to coincide with the 50th anniversary of the release of the record. The material was remixed and produced by Giles Martin, the son of the late George Martin, who produced the original version of the record. Mixing was done by Sam Okell. The album is supplemented with 23 tracks of the group\'s rare recordings.',
    49.9,
    '0602508044566',
    'kaleo_0.png',
    '2020-01-01',
    13,
    'Music Group',
    'new'
);

INSERT INTO public.collections (
    id, lang, availability, name, description, cost, eanupc, poster, publish_date, author_id, label, condition
) VALUES (
    15,
    'En',
    true,
    'Dont smile at me',
    E'Don\'t Smile at Me is the debut EP by rising global star, singer-songwriter Billie Eilish, released on August 11, 2017 via Interscope Records. The release contains several of her previously released singles, including "Ocean Eyes", "Bellyache", "Watch" and "idontwannabeyouanymore"',
    49.9,
    '0602557919486',
    'eilish_1_0.png',
    '2020-01-01',
    11,
    'Interscope Records / Darkroom',
    'new'
);

ALTER SEQUENCE collections_id_seq RESTART WITH 16;

--
-- ADD ATTACHMENTS
--

INSERT INTO public.attachments (collection_id, path) VALUES (1, 'tyler_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (2, 'weeknd_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (3, 'travis_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (4, 'kendrick_1.png');
INSERT INTO public.attachments (collection_id, path) VALUES (4, 'kendrick_2.png');
INSERT INTO public.attachments (collection_id, path) VALUES (4, 'kendrick_3.png');

INSERT INTO public.attachments (collection_id, path) VALUES (7, 'mac_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (9, 'linkin_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (10, 'beatles_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (11, 'peep_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (12, 'eilish_0_1.png');

INSERT INTO public.attachments (collection_id, path) VALUES (13, 'lana_1.png');
INSERT INTO public.attachments (collection_id, path) VALUES (13, 'lana_2.png');
INSERT INTO public.attachments (collection_id, path) VALUES (13, 'lana_3.png');

--
-- ADD DISKS
--

-- Tyler, the creator
INSERT INTO public.disks (id, author_id, collection_id) VALUES (1, 1, 1);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (2, 1, 1);

-- The weeknd
INSERT INTO public.disks (id, author_id, collection_id) VALUES (3, 2, 2);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (4, 2, 2);

-- Travis scott
INSERT INTO public.disks (id, author_id, collection_id) VALUES (5, 3, 3);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (6, 3, 3);

-- Kendrick Lamar
INSERT INTO public.disks (id, author_id, collection_id) VALUES (7, 4, 4);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (8, 4, 4);

-- Kanye west
INSERT INTO public.disks (id, author_id, collection_id) VALUES (9, 5, 5);

-- Xxxtentacion
INSERT INTO public.disks (id, author_id, collection_id) VALUES (10, 6, 6);

-- Mac miller
INSERT INTO public.disks (id, author_id, collection_id) VALUES (11, 7, 7);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (12, 7, 7);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (13, 7, 7);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (14, 7, 7);

-- Kanye west
INSERT INTO public.disks (id, author_id, collection_id) VALUES (15, 5, 8);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (16, 5, 8);

-- Linkin park
INSERT INTO public.disks (id, author_id, collection_id) VALUES (17, 8, 9);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (18, 8, 9);

-- Beatles
INSERT INTO public.disks (id, author_id, collection_id) VALUES (19, 9, 10);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (20, 9, 10);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (21, 9, 10);

-- Lil peep
INSERT INTO public.disks (id, author_id, collection_id) VALUES (22, 10, 11);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (23, 10, 11);

-- Billie eilish
INSERT INTO public.disks (id, author_id, collection_id) VALUES (24, 11, 12);

-- Lana del rey
INSERT INTO public.disks (id, author_id, collection_id) VALUES (25, 12, 13);
INSERT INTO public.disks (id, author_id, collection_id) VALUES (26, 12, 13);

-- Kaleo
INSERT INTO public.disks (id, author_id, collection_id) VALUES (27, 13, 14);

-- Billie eilish
INSERT INTO public.disks (id, author_id, collection_id) VALUES (28, 11, 15);

ALTER SEQUENCE disks_id_seq RESTART WITH 30;

--
-- ADD SONGS
--
-- Пиздец, какого хуя так много
--

-- Tyler, the creator DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, E'Igor\'s Theme', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'I Think', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'Boyfriend', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'Running Out Of Time', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'New Magic Wand', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'A Boy Is A Gun', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 1, 'Puppet', 6);

-- Tyler, the creator DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 2, E'What\'s Good', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 2, 'Gone, Gone / Thank You', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 2, E'I Don\'t Love You Anymore', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (1, 1, 2, 'Are We Still Friends?', 3);

-- The weeknd DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'IA1. Save Your Tears', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'A2. Blinding Lights', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'A3. In Your Eyes', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'A4. Can’t Feel My Face', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'A5. I Feel It Coming (With Daft Punk)', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'B1. Starboy (With Daft Punk)', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'B2. Pray For Me (With Kendrick Lamar)', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'B3. Heartless', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'B4. Often', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 3, 'B5. The Hills', 9);

-- The weeknd DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'C1. Call Out My Name', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'C2. Die For You', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'C3. Earned It (Fifty Shades Of Grey)', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'C4. Love Me Harder (With Ariana Grande)', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'D1. Acquainted', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'D2. Wicked Games', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'D3. The Morning', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (2, 2, 4, 'D4. After Hours', 7);

-- Travis scott DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'Stargazing', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'Carousel', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'Sicko Mode', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'R.I.P Screw', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'Stop Trying To Be God', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'No Bystanders', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 5, 'Skeletons', 6);

-- Travis scott DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Wake Up', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, '5% Tint', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'NC-17', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Astrothunder', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Yosemite', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, E'Can\'t Say', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Who? What!', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Butterfly Effect', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Houstonfornication', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (3, 3, 6, 'Coffee Bean', 9);

-- Kendrick Lamar DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, E'Wesley\'s Theory', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'For Free? (Interlude)', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'King Kunta', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'Institutionalized', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'These Walls', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'U', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'Alright', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 7, 'For Sale? (Interlude)', 7);


-- Kendrick Lamar DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'Momma', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'Astrothunder', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'Hood Politics', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'How Much a Dollar Cost', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'Complexion', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'The Blacker the Berry', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'i', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (4, 4, 8, 'Mortal Man', 7);

-- Kanye west DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'I Thought About Killing You', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'Yikes', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'All Mine', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, E'Wouldn\'t Leave', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'No Mistakes', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'Ghost Town', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 5, 9, 'Violent Crimes', 6);

-- Xxxtentacion DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Introduction', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Guardian Angel', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Train Food', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Whoa (Mind In Awe)', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Bad!', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Staring At The Sky', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'One Minute', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'Difference (Interlude)', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, E'I Don\'t Let Go', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (6, 6, 10, 'What Are You So Afraid Of', 9);

-- Mac miller DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Come Back to Earth', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Hurt Feelings', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'What’s The Use?', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Perfecto', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Self Care', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Wings', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 11, 'Ladders', 6);

-- Mac miller DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, 'Small Worlds', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, 'Conversation Pt. 1', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, 'Dunno', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, 'Jet Fuel', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, '2009', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 12, 'So It Goes', 5);

-- Mac miller DISK 3
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Circles', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Complicated', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Blue World', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Good News', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'I Can See', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Everybody', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Woods', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 13, 'Hand Me Downs', 7);

-- Mac miller DISK 4
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'That’s On me', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'Hands', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'Surf', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'Once A Day', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'Right', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (7, 7, 14, 'Floating', 5);

-- Kanye west DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Wake Up Mr. West', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, E'Heard \'Em Say', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Touch The Sky', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Gold Digger', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Skit #1', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Drive Slow', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'My Way Home', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Crack Music', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Roses', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 15, 'Bring Me Down', 9);

-- Kanye west DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Addiction', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Skit #2', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Diamonds From Sierra Leone (Remix)', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'We Major', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Skit #3', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Hey Mama', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Celebration', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Skit #4', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (5, 8, 16, 'Gone', 8);

-- Linkin Park DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, 'Foreword', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, E'Don\'t Stay', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, 'Somewhere I Belong', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, 'Lying From You', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, 'Hit The Floor', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 17, 'Easier To Run', 5);

-- Linkin Park DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'Faint', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'Figure.09', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'Breaking The Habit', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'From The Inside', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, E'Nobody\'s Listening', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'Session', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (8, 9, 18, 'Numb', 6);

-- Beatles DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Come Together', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Something', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, E'Maxwell\'s Silver Hammer', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Oh! Darling', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, E'Octopus\'s Garden', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, E'I Want You (She\'s So Heavy)', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Here Comes the Sun', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Because', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'You Never Give Me Your Money', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Sun King', 9);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Mean Mr. Mustard', 10);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Polythene Pam', 11);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'She Came in Through', 12);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Golden Slumbers', 13);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Carry That Weight', 14);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'The End', 15);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 19, 'Her Majesty', 16);

-- Beatles DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, E'I Want You (She\'s So Heavy)', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Goodbye', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Something (Studio)', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'The Ballad Of John', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Old Brown Shoe', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Oh! Darling (Take 4)', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, E'Octopus\'s Garden (Take 9)', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'You Never Give Me Your Money (Take 36)', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Her Majesty (Takes 1-3)', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Golden Slumbers/Carry That Weight (Takes 1-3 / Medley)', 9);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, 'Here Comes The Sun (Take 9)', 10);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 20, E'Maxwell\'s Silver Hammer (Take 12)', 11);

-- Beatles DISK 3
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Come Together (Take 5)', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'The End (Take 3)', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Come And Get It (Studio Demo)', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Sun King (Take 20)', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Mean Mr Mustard (Take 20)', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Polythene Pam (Take 27)', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'She Came In Through The Bathroom Window (Take 27)', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Because (Take 1 - Instrumental)', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'The Long One (Trial Edit & Mix - 30 July 1969)', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Something (Take 39 - Instrumental - Strings Only)', 9);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (9, 10, 21, 'Golden Slumbers/Carry That Weight (Take 17 - Instrumental - Strings & Brass Only)', 10);

-- Lil peep DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'Benz Truck', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'Save That Shit', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'Awful Things', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'U Said', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'Better Off (Dying)', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'The Brightside', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 22, 'Problems', 6);

-- Lil peep DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Broken Smile (My All)', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Runaway', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Sex with My Ex', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Cry Alone', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, E'Leanin\'', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, '16 Lines', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Life is Beautiful', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Hate Me', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'IDGAF', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'White Girl', 9);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (10, 11, 23, 'Fingers', 10);

-- Billie eilish DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Bad Guy', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Xanny', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'You Should See Me In A Crown', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'All The Good Girls Go To Hell', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Wish You Were Gay', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, E'When The Party\'s Over', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, '8', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'My Strange Addiction', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Bury A Friend', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Ilomilo', 9);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Listen Before I Go', 10);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'I Love You', 11);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 12, 24, 'Goodbye', 12);

-- Lana del rey DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Born To Die', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Off To The Races', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Blue Jeans', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Video Games', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Diet Mountain Dew', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'National Anthem', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Dark Paradise', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 25, 'Radio', 7);

-- Lana del rey DISK 2
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Carmen', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Million Dollar Man', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Summertime Sadness', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'This Is What Makes Us Girls', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Without You (Bonus Track)', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Lolita (Bonus Track)', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (12, 13, 26, 'Lucky Ones (Bonus Track)', 6);

-- Kaleo DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Introduction', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Guardian Angel', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Train Food', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Whoa (Mind In Awe)', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Bad!', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Staring At The Sky', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'One Minute', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'Difference (Interlude)', 7);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, E'I Don\'t Let Go', 8);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (13, 14, 27, 'What Are You So Afraid Of', 9);

-- Billie eilish DISK 1
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'COPYCAT', 0);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'idontwannabeyouanymore', 1);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'my boy', 2);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'watch', 3);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'party favor', 4);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'bellyache', 5);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'ocean eyes', 6);
INSERT INTO public.songs (author_id, collection_id, disk_id, name, "order") VALUES (11, 15, 28, 'hostage', 7);

--
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- Мои глаза...
--