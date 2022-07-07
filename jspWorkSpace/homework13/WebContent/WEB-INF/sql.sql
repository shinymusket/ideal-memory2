DROP TABLE board_tbl;

CREATE TABLE board_tbl (
    idx NUMBER(6) CONSTRAINT PK_board_tbl PRIMARY KEY,
    writer VARCHAR2(20),
    subject VARCHAR2(255),
    content CLOB,
    regdate DATE
);

SELECT * FROM board_tbl;
ALTER session set NLS_DATE_FORMAT = 'YYYY/MM/DD HH24:MI:SS';

CREATE SEQUENCE seq_board_tbl
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '김회원', '정보처리 산업기사 쉽다', 'jsp 쉽네요', to_date('18/07/31 12:34:56', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '김회원', '웹 디자인 기능사 어렵다', 'jquery 어렵네요', to_date('18/07/31 12:43:43', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '이회원', '정보처리 산업기사 어렵다', 'jsp 어렵네요', to_date('18/08/01 13:34:56', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '이회원', '정보처리 산업기사 쉽다', 'jquery 쉽네요', to_date('18/08/01 13:43:34', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '박회원', 'ㅈㄱㄴ', '제목 그대로 내용', to_date('18/08/02 13:12:10', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '박회원', '제목 그대로 내용', 'ㅈㄱㄴ', to_date('18/08/03 14:34:20', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '강회원', '하드코딩하는 사람들', '가입하면 좋음', to_date('18/08/04 14:56:30', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '나회원', 'github를 사용합시다', '신세계', to_date('18/08/05 15:43:35', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '문회원', '노는 게 제일좋아', '모두들 모여라', to_date('18/08/06 16:21:40', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, '지회원', '여름아', '부탁해', to_date('18/08/07 17:01:45', 'YY/MM/DD HH24:MI:SS'));

COMMIT;

CREATE TABLE commnet_tbl (
    idx NUMBER(6) CONSTRAINT PK_commnet_tbl PRIMARY KEY,
    bidx NUMBER(6),
    witer VARCHAR2(20),
    content CLOB,
    regdate DATE
);

CREATE SEQUENCE seq_commnet_tbl
START WITH 1
INCREMENT BY 1
NOCACHE;

SELECT * FROM commnet_tbl;

UPDATE commnet_tbl SET bidx=9 WHERE bidx=8;

INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 1, '김회원', 'Lorem ipsum dolor sit amet', to_date('18/08/01 12:34:56', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 3, '김회원', 'consectetur adipiscing elit', to_date('18/08/01 12:43:43', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 5, '이회원', 'sed do eiusmod tempor', to_date('18/08/02 13:34:56', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 7, '이회원', 'incididunt ut labore et', to_date('18/08/03 13:43:34', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 9, '박회원', 'dolore magna aliqua', to_date('18/08/04 13:12:10', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 2, '박회원', 'minim veniam, quis nostrud', to_date('18/08/04 14:34:20', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 3, '강회원', 'exercitation ullamco laboris', to_date('18/08/05 14:56:30', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 5, '나회원', 'nisi ut aliquip', to_date('18/08/06 15:43:35', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 7, '문회원', 'ex ea commodo consequat', to_date('18/08/07 16:21:40', 'YY/MM/DD HH24:MI:SS'));
INSERT INTO commnet_tbl VALUES(SEQ_COMMNET_TBL.nextval, 2, '지회원', 'Duis aute irure dolor', to_date('18/08/07 17:01:45', 'YY/MM/DD HH24:MI:SS'));