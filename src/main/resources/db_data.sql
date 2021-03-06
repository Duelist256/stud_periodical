INSERT INTO inform_system.users (login, password, salt, name) VALUES
('test1@test.com','79a5c3c193388ffc29e1a11cb42ae90b4684a3b10c6220109e94d23ec33af1ca','a+YVr1cGo4sVpeQIwTaRXd38tmsP4j8wOZiqmamrIiE=','Test1'),
('test2@test.com','23606353b8bb423627dde13a928e093f0b6c226ee80e1b8351b8d26674e8b29c','0FTw7/7BXK8rfD41gFy9eEe13YRs05+WJPQTziIamOo=','Test2'),
('test3@test.com','15dbaefc65a0a32d84f37c641b4ddc62486fbd66cf8a9bfce451ebfc01ba03ba','4YxNzz4QYw5fbttHQkobEYpMP228N/kpY0bt319Y76k=','Test3'),
('test4@test.com','47418f4350f46a39f030511ddf2487f3d5d98d1ab547a5ca07007c0b9473684c','80YT6J+zucFxWeaCXE7R+twvPvWxSojuXEe1G6g0nV4=','Test4'),
('test5@test.com','ce8241cef96aa77d8334d7586a16fefb0d8802b2e0504100e3341ef3237528e1','PU5CTzlhZU08fdtPWUlcZtoQ9Gtat89YtkHbW9l0PYE=','Test5'),
('test6@test.com','530422520a86dfa4f8edada5bc51b7426af99788762e7f572786e0f05a957942','bpdCuBaHgzuncN2N/s0HERUMBxu8A+MjT7V2c92z6rQ=','Test6'),
('test7@test.com','c0f9c162228c384093b57cb777d717ff5026a55c940d328a53b1de8b09c48ee7','UnscCi0GcJr/b/AGNCNmDJ+0xPJNpCJ/xsiKsNVKm4U=','Test7'),
('test8@test.com','b7d636855a01653aca82dd86c61d091fae3e426e673484499ccbc27c03c2bc45','Yz157BO1E7i/zC7y4GUGJQ/0qVnNSULuJ2HXPoqyAVg=','Test8'),
('test9@test.com','a3d391971c8359095cec0b9c82766e6d11a659eaef9a436ac92e4c0a90bcfb2d','PuOWhtlBicViE3IJRRUZUKlFwD4rqYNWKAVeTOlIsIA=','Test9'),
('test10@test.com','099d9eeb753d33c9be64a4238dd29a291fc49d767446266948cec774ca3bad00','6QmZGPY+IqLPOEd9lXZAI8wIRRT8ZlHe34orQ9ecNQY=','Test10'),
('test11@test.com','0896f5a99c722c9df08374609ac50b9f0693dd8596aa76bbe186c943a61f4cee','mSURKJNGwM1SDlQ/B7lRS8T30KB+pgjngHKNdSp6U3Q=','Test11'),
('test12@test.com','e48439e26a3858f46d3f03952aec524599b4d0f8607410f5f07267bb1a4354f9','OdGwOg7djtwzpNI9DY8L2EFAbef/tMzoZ/6jYEgYHvk=','Test12'),
('test13@test.com','5d0106bcb663d8fde5e6987884dfe8632a561765baeaa0b8feffc6cb5e3caf42','4IzOVksPF2QgQXzGTYMKfxHlzb2yPUhZLMb0Xl7ZhxM=','Test13'),
('test14@test.com','ebcf28fbaea03f27e5874bdb85bdc21e58bedc13bdfd6383ad76cfb0e8c15de1','UZSF+Eo8IGnFWAaj9cuuCiVTlZF3THxaxlWJgJTYW7c=','Test14'),
('test15@test.com','815a767b5de48969225270ff07d7e8b81153f4091e385219d52ad5d9bd9c39c4','NGiLB4TyCt8i7v7x6fhLdVJd+d3/0UoDlm/PIcVZtzY=','Test15'),
('test16@test.com','4abcd4ba9694358affae398257ca128f0a0b35b4b5e96295fead58739f8a0e64','KNmx9L4eDMlSdkll9ZReowNFNDeYJ6+CTnx01j0VlG8=','Test16'),
('test17@test.com','84b3f1c830d910df472fae7a5994250d5cd9c6bab71971cd8443b089bbd5e0ab','ARgVuU7f2+dzNiWpW2Ew5VHFG2bDmOLzMRbalmvjnNs=','Test17'),
('test18@test.com','0e6ac009d9497a63bda711b9e7f1afb727af9c26aaba62a35b0cc466e3225336','ats6G7WU/iIeZlu5QWDtgNf6ExCyxvfi7nqHFv9l2Z0=','Test18'),
('test19@test.com','c32145d7dffc9cc0b638567c0fcfaf9b86d4c88470900b14eaa15b893fd2ccb0','++6QJs9qipAmNQzTYJQ5YAeitnfI65CqrrbFrKDHN1s=','Test19'),
('test20@test.com','803da8827f0758595c22c52d02416e3102e6fcb6ecfe12c076395ae6498322f8','VM9Q0SgUDUbs3LA+LOyAgVgzmiGp3m1ubR7fpklOTWU=','Test20');
-- For each accounts passwords test1, test2 ... test20 respectively

INSERT INTO inform_system.users (login, password, salt, name, isAdmin) VALUES
('admin@test.com','2199700756900cac220c305b8be1b1d4ee567f9f389bd194a644062500b3ba91','cB0Dh/agK8WHuAETRL8h2DPJXKsXMxM/8T2Nu/lXsF0=','Admin', TRUE);
-- login "admin@test.com", password "admin"

INSERT INTO inform_system.periodicals (title, description, publisher, genre, price, img_path) VALUES
('Eggplant Rage','Insane Fury','publisher1','genre1', 100.21, '/img/img1.jpg'),
('Cats I used to know','Once a summer day','publisher2','genre2', 101.22, '/img/img2.jpg'),
('Martial Badminton','Theory and practice','publisher3','genre3', 102.23, '/img/img3.jpg'),
('Concrete history','A hard year it was','publisher4','genre4', 103.24, '/img/img4.jpg'),
('Learn Italian without words','Adorabimente','publisher5','genre5', 104.25, '/img/img5.jpg'),
('Knitting quickstart','3, 2, 1...','publisher6','genre6', 105.26, '/img/img6.jpg'),
('Toes-Readers','In case...','publisher7','genre7', 106.27, '/img/img7.jpg'),
('Teabags'' mystery','You didn''t expect them to come back','publisher8','genre8', 107.28, '/img/img8.jpg'),
('Metallist''s guide','Know yourself','publisher9','genre9', 108.29, '/img/img9.jpg'),
('Potatoes and vegetables','18+','publisher10','genre10', 109, '/img/img10.jpg'),
('Avos''','Songs for astronaut','publisher11','genre11', 110, '/img/img11.jpg'),
('Weeds in changing world','The choice is yours','publisher12','genre12', 111, '/img/img12.jpg'),
('Bangram','Zero gravity melee fight','publisher13','genre13', 112, '/img/img13.jpg'),
('Martial badminton','Theory and practice','publisher14','genre14', 113, '/img/img14.jpg'),
('Yesterday and forever','Make a logo in 1 evening','publisher15','genre15', 114, '/img/img15.jpg'),
('Duel lawbook','Board-officer tutorial','publisher16','genre16', 115, '/img/img16.jpg'),
('Pick-up basics','For little ones','publisher17','genre17', 116, '/img/img17.jpg'),
('DIY','Make a satellite with soap and foil','publisher18','genre18', 117, '/img/img18.jpg'),
('Borsch','Family reunion means','publisher19','genre19', 118, '/img/img19.jpg'),
('Wi-Fi','Truth or myth','publisher20','genre20', 119, '/img/img20.jpg');