package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InsertTable {
    public static ArrayList<String> InsertData = new ArrayList<>();

    static {
        // 사용자 테이블 데이터
        InsertData.add("INSERT INTO KUSERTABLE (USERID, USERPASSWORD, USERNAME) VALUES ('user1', 'password1', 'John Doe')");
        InsertData.add("INSERT INTO KUSERTABLE (USERID, USERPASSWORD, USERNAME) VALUES ('user2', 'password2', 'Jane Smith')");
        InsertData.add("INSERT INTO KUSERTABLE (USERID, USERPASSWORD, USERNAME) VALUES ('user3', 'password3', 'Alice Johnson')");
        InsertData.add("INSERT INTO KUSERTABLE (USERID, USERPASSWORD, USERNAME) VALUES ('user4', 'password4', 'Bob Brown')");
        InsertData.add("INSERT INTO KUSERTABLE (USERID, USERPASSWORD, USERNAME) VALUES ('user5', 'password5', 'Charlie Davis')");

        // 작가 테이블 데이터
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('J.K. Rowling')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('하루키 무라카미')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('박완서')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Mark Twain')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('이문열')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Agatha Christie')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('유시민')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Haruki Murakami')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('김훈')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('허먼 멜빌')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('정유정')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('John Steinbeck')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('조정래')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Dostoevsky')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('한강')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('James Joyce')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('김애란')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Toni Morrison')");
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('정호승')");

        // 출판사 테이블 데이터
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('문학동네')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('민음사')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('작가정신')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('창비')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('열림원')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Random House')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Penguin Books')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('HarperCollins')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Hachette Book Group')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Simon & Schuster')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Alfred A. Knopf')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Macmillan')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Scholastic')");
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Farrar, Straus and Giroux')");

        // 장르 테이블 데이터
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('소설')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('에세이')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('시')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('과학')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('철학')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('자기계발')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('역사')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('문화')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('심리학')");
        InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('경제학')");

        // 책 테이블 데이터
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('해리 포터와 마법사의 돌', 1, 3, 12)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('1984', 5, 5, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('노르웨이의 숲', 8, 8, 15)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('백년 동안의 고독', 4, 6, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('소나기', 7, 7, 20)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('삼국지', 12, 10, 18)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('오만과 편견', 10, 12, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('자기 앞의 생', 9, 14, 14)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('어린 왕자', 13, 2, 7)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('앵무새 죽이기', 6, 4, 16)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('데미안', 11, 1, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('그리스인 조르바', 3, 9, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('나미야 잡화점의 기적', 14, 15, 12)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('어둠의 속도', 15, 13, 5)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('반지의 제왕', 18, 11, 9)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('나의 라임 오렌지나무', 17, 5, 7)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('무소의 뿔처럼 혼자서 가라', 2, 4, 13)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('무엇을 할 것인가', 19, 3, 6)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('피지컬', 16, 2, 11)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('탑걸', 20, 1, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('신경 끄기의 기술', 2, 6, 20)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('어린 왕자', 1, 5, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('죽은 시인의 사회', 7, 7, 18)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('그리스인 조르바', 3, 9, 14)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('사피엔스', 5, 2, 12)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('레미제라블', 4, 8, 16)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('피안', 12, 10, 5)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('미래의 역사', 11, 15, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('검은 사제들', 13, 1, 7)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('불멸의 이순신', 15, 12, 9)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('동물농장', 14, 4, 11)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('셜록 홈즈의 모험', 10, 6, 13)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('황금가지', 18, 3, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('고요한 아침의 나라', 16, 11, 6)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('말리와 나', 19, 8, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('마법의 기구', 20, 9, 7)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('소녀와 독수리', 9, 5, 15)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('세상에서 가장 아름다운 이별', 8, 14, 12)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('자기계발의 진리', 7, 13, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('인간 실격', 6, 4, 20)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('행복을 찾아서', 5, 7, 14)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('상실의 시대', 3, 15, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('아이를 위한 이야기', 12, 1, 10)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('몽테크리스토 백작', 14, 10, 9)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('황금벌레', 1, 12, 15)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('그대, 고요한 아침', 4, 11, 8)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('이방인', 13, 9, 12)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('빛의 속도', 20, 5, 7)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('꿈꾸는 다락방', 19, 2, 6)");
        InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('시간 여행자의 아내', 16, 3, 10)");
        
        // 장르-책 매핑 테이블 데이터
        InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (1, 1)");
        InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (2, 2)");
        InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (3, 3)");
        InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (4, 4)");
        InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (5, 5)");

        // 랜탈 테이블 데이터
        InsertData.add("INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (1, 1, SYSDATE, SYSDATE + 7)");
        InsertData.add("INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (2, 2, SYSDATE, SYSDATE + 7)");
        InsertData.add("INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (3, 3, SYSDATE, SYSDATE + 7)");
        InsertData.add("INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (4, 4, SYSDATE, SYSDATE + 7)");
        InsertData.add("INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (5, 5, SYSDATE, SYSDATE + 7)");

        // 장바구니 테이블 데이터
        InsertData.add("INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO) VALUES (1, 1)");
        InsertData.add("INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO) VALUES (2, 1)");
        InsertData.add("INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO) VALUES (3, 2)");
        InsertData.add("INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO) VALUES (4, 3)");
        InsertData.add("INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO) VALUES (5, 4)");
    }
    public static void inputData() {
        for (String sql: InsertData) {
            CgwDAO.executeUpdateSql(sql);
        }
    }
    public static void main(String[] args) {
        inputData();
    }
}