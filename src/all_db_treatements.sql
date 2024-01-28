CREATE TABLE ENTITE (id integer GENERATED ALWAYS as IDENTITY PRIMARY KEY
,name VARCHAR2(255),description varchar2(255),mcd INTEGER
,CONSTRAINT FK_MCD FOREIGN KEY (mcd) references mcd(id) );


CREATE TABLE MCD (id integer GENERATED ALWAYS as IDENTITY PRIMARY KEY
,slug VARCHAR2(255),name VARCHAR2(255),description VARCHAR2(255), date_created TIMESTAMP
,date_modified TIMESTAMP,UUID VARCHAR2(255));

CREATE TABLE RELATION (id integer GENERATED ALWAYS as IDENTITY PRIMARY KEY,
name VARCHAR2(255),description varchar2(255),cardinality_one varchar2(255),cardinality_two varchar2(255)
,entity_one integer,entity_two integer,
CONSTRAINT FK_ENTITY_ONE FOREIGN KEY (entity_one) references ENTITE(id),
CONSTRAINT FK_ENTITY_TWO FOREIGN KEY (entity_two) references ENTITE(id));

CREATE TABLE ATTRIBUT (id integer GENERATED ALWAYS as IDENTITY PRIMARY KEY,
name VARCHAR2(255),type VARCHAR2(255),entite_id integer,
CONSTRAINT FK_ENTITY FOREIGN KEY (entite_id) REFERENCES ENTITE(id));