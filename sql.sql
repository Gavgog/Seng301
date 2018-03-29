
create table vehicle (vinNum primary key,make text, model text, fuelType text check (fuelType in ('diesel','petrol','electric','gas','other')), odometer number, firstRego date, wofExpiry date, carType text check (carType in ('MA', 'MB','MC', 'T','O')) ,ownerEmail text, FOREIGN KEY (ownerEmail) REFERENCES owner(email));

