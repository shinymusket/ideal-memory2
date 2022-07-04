CREATE TABLE ex_memberinfo(
 id VARCHAR2(20) PRIMARY KEY,
 passwd VARCHAR2(20) NOT NULL,
 name VARCHAR2(20) NOT NULL,
 email VARCHAR2(50) NOT NULL,
 nickname VARCHAR2(30) NOT NULL,
 reg_date date DEFAULT sysdate
);

DROP TABLE ex_memberinfo;

SELECT * FROM ex_memberinfo;

UPDATE ex_memberinfo SET name=?, nickname=?, email=? WHERE id=?;

SELECT COUNT(*) FROM ex_memberinfo WHERE id=?;

INSERT INTO ex_memberinfo(id, passwd, name, email, nickname) VALUES(?, ?, ?, ?, ?);

SELECT passwd FROM ex_memberinfo WHERE id=?;

SELECT * FROM ex_memberinfo WHERE id=?;

SELECT * FROM ex_memberinfo;

UPDATE ex_memberinfo SET passwd=? WHERE id=?;

DELETE ex_memberinfo WHERE id=?;

CREATE table ex_board(
    id VARCHAR2(20) REFERENCES ex_memberinfo(id), -- ex_memberinfo 테이블의 id 참조
    board_no number PRIMARY KEY, --  게시판 입력 순서
    board_subject VARCHAR2(50) NOT NULL, -- 제목
    board_content LONG NOT NULL, -- 내용(위지윅 적용을 위해 long 타입 설정)
    ip VARCHAR2(30) NOT NULL,
    readcount NUMBER DEFAULT 0, -- 조회수
    file_name VARCHAR2(50),
    section VARCHAR2(30), -- nav에서 선택한 항목별 저장할 section 명
    write_date DATE NOT NULL -- 작성일
);

CREATE SEQUENCE seq_ex_board_no -- board_no 시퀀스 생성
INCREMENT BY 1
START WITH 1;