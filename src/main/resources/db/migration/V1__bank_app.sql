create table customer (
	id int(10) not null auto_increment,
  fullname varchar(30) not null,
  address varchar(75) not null,
  age int(10) not null,
  primary key (id)
);

create table bank_account (
	id int(10) not null auto_increment,
  customer_id int(10) not null,
  money decimal(15, 4) not null,
  primary key (id),
  constraint foreign key (customer_id) references customer (id)
);

create table bank_operation (
	id int (10) not null auto_increment,
  account_id int(10) not null,
  op_type tinyint(1) not null,
  money decimal(15, 4) not null,
  op_date timestamp not null,
  primary key (id),
  constraint foreign key (account_id) references bank_account (id)
);

insert into customer (fullname, address, age) values
('David Abbott', '733 Oxford Road Libertyville, IL 60048', 34),
('Graham Anderson', '888 Argyle Ave. Sykesville, MD 21784', 45),
('Christina Arrowsmith', '12 South Longbranch Ave. Enfield, CT 06082', 23),
('Ozan Aydin', '14 Clay St. Sewell, NJ 08080', 45),
('Arun Banerjee', '8663 County St. Carlisle, PA 17013', 67),
('Anthony Barnard', '770 Pierce Court Meriden, CT 06450', 65),
('Jermaine Barrett', '96 Proctor St. Huntley, IL 60142', 43),
('Jason Berry', '96 East Lakeshore Rd. Richmond Hill, NY 11418', 18),
('Pauline Brand', '79 Jones Street Great Falls, MT 59404', 45),
('Michelle Burley', '81 Fieldstone Rd. Long Beach, NY 11561', 43),
('Sheila Chopra', '693 N. Lakeview Ave. Norcross, GA 30092', 32),
('James Connolly', '78 Smoky Hollow Court Auburn, NY 13021', 44),
('Ryan Davis', '944 Studebaker Street Grand Blanc, MI 48439', 33),
('John Day', '7867 Atlantic Street Racine, WI 53402', 54),
('Frederick Duckworth', '9595 Deerfield Dr. Menasha, WI 54952', 65),
('Lee Figg', '19 Lexington Court Bowie, MD 20715', 89),
('Patrick Gadsby', '67 Lake View Ave. Point Pleasant Beach, NJ 08742', 57),
('Christine Gilbert', '58 South Willow Lane San Angelo, TX 76901', 51),
('Rebecca Goldberg', '8396 Pearl Road Mentor, OH 44060', 23),
('Andrew Golding', '3 Henry Smith Street Battle Creek, MI 49015', 42),
('Wayne Golding', '96 East Ridge Lane Allen Park, MI 48101', 31),
('Rudolph Grant', '8695 Plymouth St. Kenosha, WI 53140', 33),
('Keith Gratton', '9448 San Juan Court Hermitage, TN 37076', 30),
('Neil Hammond', '120 Shady Ave. Lake Villa, IL 60046', 21),
('Jahanara Haque', '3 Fieldstone St. Ashburn, VA 20147', 23),
('Mohammed Hasan', '90 Hillside Lane Adrian, MI 49221', 24),
('Matthew Jefferys', '11 Addison Lane Clearwater, FL 33756', 45),
('Carol John', '8081 Cambridge St. Navarre, FL 32566', 47),
('Heidi Jones', '293 Silver Spear Ave. Saint Augustine, FL 32084', 53),
('Phil Kirwin', '23 N. Cactus Ave. Superior, WI 54880', 42),
('Jacqueline MacKay', '9399 Bow Ridge Street Columbus, GA 31904', 23),
('Dean McDonald', '8034 Bay Lane Powell, TN 37849', 43),
('Emma Mumford', '7118 Sutor St. Bethel Park, PA 15102', 55),
('Stanley Perkins', '9063 Valley Street Dekalb, IL 60115', 46),
('Alexander Queenan', '43 Courtland Dr. Springboro, OH 45066', 45),
('Yasmin Rehman', '8072 Alderwood Road Mcallen, TX 78501', 19),
('David Ringer', '9271 Del Monte Avenue Littleton, CO 80123', 32),
('David Smith', '8991 Overlook St. Helotes, TX 78023', 43),
('Lionel Smith', '405 Race Ave. Hallandale, FL 33009', 23),
('Ritesh Srivastava', '33 North Columbia Road Brockton, MA 02301', 23),
('Neil Stevenson', '694 E. Newport Ave. Norwich, CT 06360', 43),
('Deborah Taylor', '471 Berkshire Ave. Urbandale, IA 50322', 23),
('Scott Taylor', '197 N. Colonial St. Grandville, MI 49418', 34),
('Michelle Taylor', '95 Southampton Dr. Danville, VA 24540', 55),
('Stephanie Taylor', '8095 North Ashley Dr. Emporia, KS 66801', 34),
('Togy Thomas', '753 Bay Dr. North Canton, OH 44720', 43),
('Hayden Todd', '760 Trout Lane Cantonment, FL 32533', 34),
('Carole-Anne Turner', '9502 SE. Columbia Street Natick, MA 01760', 23),
('Clive Wightman', '179 Creek Dr. Knoxville, TN 37918', 23),
('Lee Wright', '719 West Devonshire Ave. Alpharetta, GA 30004', 43);

insert into bank_account (customer_id, money) values
(1, 234234.34), (1, 237737.53), (2, 776.55), (2, 4454.57), (3, 2334.55),
(3, 2342346.34), (4, 465757.95), (5, 964785.55), (6, 6546.56), (7, 22.34),
(8, 4367.76), (8, 0658.56), (8, 565.89), (9, 87579.55), (10, 0.55), (11, 4675.46),
(11, 88665.76), (11, 4566.86), (12, 5836.54), (12, 689.65), (13, 5654.98), (14, 5675.75),
(15, 454.55), (15, 34557.55), (16, 3234.12), (16, 12743.54), (17, 7995.66), (18, 9976.64),
(18, 46468.65), (19, 56588.57), (19, 7655.57), (20, 7754.88), (21, 8654.64), (22, 854.00),
(23, 4562.64), (23, 668.44), (24, 6543.99), (25, 5789.74), (26, 844.54), (26, 5455.86),
(27, 633.43), (28, 5212.54),(29, 47.44), (29, 4688.43), (30, 46689.44), (31, 899.55),
(31, 578.43), (31, 4778.34), (32, 5653.56), (33, 363.33), (33, 377.75), (33, 7433.77),
(33, 3736.64), (34, 656.65), (35, 653.56), (35, 845.74), (36, 9999999.99), (37, 676765.67),
(38, 6777.77), (39, 25252.34), (40, 363277.44), (41, 467983.44), (41, 45.45), (41, 8008.88),
(42, 22473.55), (42, 567.44), (43, 44.76), (43, 557.55), (44, 6589.56), (45, 567.565),
(45, 5588.53), (46, 755.56), (46, 89.65), (46, 559.54), (47, 67.56), (48, 579.67), (49, 679.54),
(50, 679.65), (50, 66.44);