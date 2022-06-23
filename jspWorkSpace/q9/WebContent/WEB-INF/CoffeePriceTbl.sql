CREATE TABLE CoffeePriceTbl(
    coffeeNum number PRIMARY KEY,
    coffeeName VARCHAR2(50),
    coffeeType VARCHAR2(10),
    price number(5)
);

CREATE SEQUENCE cNum_seq
NOCACHE;

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '돌체 라떼', '톨', 5600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '돌체 라떼', '그란데', 6100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '돌체 라떼', '벤티', 6600);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '화이트 초콜릿 모카', '톨', 5600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '화이트 초콜릿 모카', '그란데', 6100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '화이트 초콜릿 모카', '벤티', 6600);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 모카', '톨', 5100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 모카', '그란데', 5600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 모카', '벤티', 6100);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 라떼', '톨', 4600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 라떼', '그란데', 5100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '카페 라떼', '벤티', 5600);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '아메리카노', '톨', 4100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '아메리카노', '그란데', 4600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '아메리카노', '벤티', 5100);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '오늘의 커피', '톨', 3800);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '오늘의 커피', '그란데', 4300);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '오늘의 커피', '벤티', 4800);

INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '블론드 바닐라 더블샷 마키아또', '톨', 5600);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '블론드 바닐라 더블샷 마키아또', '그란데', 6100);
INSERT INTO CoffeePriceTbl
VALUES (CNUM_SEQ.nextval, '블론드 바닐라 더블샷 마키아또', '벤티', 6600);