
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS pet_owner;
DROP TABLE IF EXISTS pet_diet;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS diet;
DROP TABLE IF EXISTS owner;


CREATE TABLE owner (
owner_id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL, 
last_name VARCHAR(40) NOT NULL, 
address VARCHAR(100),
phone_no VARCHAR(20),
PRIMARY KEY (owner_id)
);


CREATE TABLE diet (
diet_id INT AUTO_INCREMENT NOT NULL, 
diet_name VARCHAR(40) NOT NULL, 
prep_time VARCHAR(40) NOT NULL,
PRIMARY KEY (diet_id)
);

CREATE TABLE pet (
pet_id INT NOT NULL AUTO_INCREMENT,
owner_id INT NOT NULL,
pet_name VARCHAR(40) NOT NULL,
species VARCHAR(40) NOT NULL, 
breed VARCHAR(40),
age INT NOT NULL,
pet_size ENUM ('TINY', 'SMALL', 'MEDIUM', 'LARGE', 'HUGE'),
hair_length ENUM ('NONE', 'SHORT', 'MEDIUM', 'LONG'),
PRIMARY KEY (pet_id),
FOREIGN KEY (owner_id) REFERENCES owner (owner_id) ON DELETE CASCADE
);


CREATE TABLE pet_diet (
pet_id INT NOT NULL, 
diet_id INT NOT NULL,
FOREIGN KEY (diet_id) REFERENCES diet (diet_id) ON DELETE CASCADE,
FOREIGN KEY (pet_id) REFERENCES pet (pet_id) ON DELETE CASCADE,
UNIQUE KEY (diet_id, pet_id)
);

CREATE TABLE pet_owner (
pet_id INT NOT NULL, 
owner_id INT NOT NULL,
FOREIGN KEY (owner_id) REFERENCES owner (owner_id) ON DELETE CASCADE,
FOREIGN KEY (pet_id) REFERENCES pet (pet_id) ON DELETE CASCADE,
UNIQUE KEY (owner_id, pet_id)
);

CREATE TABLE ingredient (
ingredient_id INT AUTO_INCREMENT NOT NULL,
diet_id INT NOT NULL,
ingredient_name VARCHAR(40) NOT NULL, 
amount_required VARCHAR(40) NOT NULL, 
PRIMARY KEY (ingredient_id),
FOREIGN KEY (diet_id) REFERENCES diet (diet_id) ON DELETE CASCADE
);



 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Charlie', 'Alexander', '545 E Adams', '12067854312');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Brett', 'Peterson', '521 N Elm', '12087534682');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Julie', 'Harold', '7854 Poplar', '15627854685');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Lexi', 'Joseph', '111 Richmond', '12087534682');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Quinn', 'Levine', '348 S Edmund', '15687945326');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Bridgett', 'Hansley', '39 N Cromwell', '12567849532');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Madison', 'Reagan', '208 Acer', '12358794621');
 INSERT INTO owner (first_name, last_name, address, phone_no ) VALUES('Candy', 'Monroe', '9864 Cottonwood', '12489653278');

 
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('1', 'Hakuna', 'Dog', 'Pomeranian', '5', 'SMALL', 'LONG');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('1', 'Freckles', 'Dog', 'Pomeranian', '2', 'SMALL', 'LONG');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('2', 'Beethoven', 'Dog', 'Bernese Mountain', '8','LARGE', 'LONG');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('3', 'Heith', 'Dog', 'Basset Hound', '3','MEDIUM', 'SHORT' );
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('4', 'Biscuit', 'Cat', 'Sphynx','6', 'SMALL', 'NONE');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('5', 'Leo', 'Lizard', 'Chameleon','2', 'SMALL', 'NONE');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('6', 'Avalanche', 'Hamster', 'Roborovski Dwarf','1', 'TINY', 'SHORT');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('7', 'Sunshine', 'Horse', 'Appaloosa','12', 'HUGE', 'SHORT');
 INSERT INTO pet (owner_id, pet_name, species, breed, age, pet_size, hair_length) VALUES('8', 'Lucky', 'Turtle', 'Red-eared slider','20', 'SMALL', 'NONE');


 INSERT INTO diet (diet_name, prep_time) VALUES('Turkey & Veggie', '20 minutes');
 INSERT INTO diet (diet_name, prep_time) VALUES('Basic lizard diet', '5 minutes');
 INSERT INTO diet (diet_name, prep_time) VALUES('Fish and Veggie', '25 minutes');

INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'ground turkey', '1 cup');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'ground turkey organ meat', '2 Tablespoons');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'grated veggies', '1/4 cup');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'ground sunflower seeds', '1 teaspoon');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'coconut oil', '1/2 cup');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'salmon oil', '1/2 teaspoon');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('1', 'Calcium Citrate', '1/4 teaspoon');

INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('2', 'large crickets', '10');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('2', 'large mealworms', '5');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('2', 'small horned worms', '2');

INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('3', 'Fish Fillets', '2 pounds');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('3', 'Canned Pink Salmon', '1 can');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('3', 'Whole eggs', '3');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('3', 'Diced Veggies', '3 cups');
INSERT INTO ingredient (diet_id, ingredient_name, amount_required) VALUES('3', 'Quinoa', '1 cup');

INSERT INTO pet_diet (pet_id, diet_id) VALUES(1,1);
INSERT INTO pet_diet (pet_id, diet_id) VALUES(3,3);
INSERT INTO pet_diet (pet_id, diet_id) VALUES(4,2);

INSERT INTO pet_owner (pet_id, owner_id) VALUES(1,1);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(2,1);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(3,2);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(4,3);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(5,4);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(6,5);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(7,6);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(8,7);
INSERT INTO pet_owner (pet_id, owner_id) VALUES(9,8);
