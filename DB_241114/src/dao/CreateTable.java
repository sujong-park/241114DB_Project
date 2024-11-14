package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateTable {
    public static ArrayList<String> CreateTables = new ArrayList<>();

    static {
        // 순서를 보장하여 CreateTables를 채우기
        CreateTables.clear();

// 1. 사용자 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRUSERTABLE (
                        USERNO NUMBER PRIMARY KEY,
                        USERID VARCHAR2(20) UNIQUE NOT NULL,
                        USERPASSWORD VARCHAR2(20) NOT NULL,
                        USERNAME VARCHAR2(20) NOT NULL
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRUSERNO_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRUSERTABLE_TRG
                    BEFORE INSERT ON DDRUSERTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.USERNO := DDRUSERNO_SEQ.NEXTVAL;
                    END;
                """);

// 2. 작가, 출판사, 장르 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRAUTHORTABLE(
                        AUTHORNO NUMBER PRIMARY KEY,
                        AUTHORNAME VARCHAR2(20) NOT NULL
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRAUTHORNO_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRAUTHORTABLE_TRG
                    BEFORE INSERT ON DDRAUTHORTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.AUTHORNO := DDRAUTHORNO_SEQ.NEXTVAL;
                    END;
                """);

        CreateTables.add("""
                    CREATE TABLE DDRPUBLISHERTABLE(
                        PUBLISHERNO NUMBER PRIMARY KEY,
                        PUBLISHERNAME VARCHAR2(20) NOT NULL
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRPUBLISHER_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRPUBLISHERTABLE_TRG
                    BEFORE INSERT ON DDRPUBLISHERTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.PUBLISHERNO := DDRPUBLISHER_SEQ.NEXTVAL;
                    END;
                """);

        CreateTables.add("""
                    CREATE TABLE DDRGENRETABLE(
                        GENRETABLENO NUMBER PRIMARY KEY,
                        GENRETABLENAME VARCHAR2(20) NOT NULL
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRGENRETABLE_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRGENRETABLE_TRG
                    BEFORE INSERT ON DDRGENRETABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.GENRETABLENO := DDRGENRETABLE_SEQ.NEXTVAL;
                    END;
                """);

// 3. 책 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRBOOKTABLE(
                        BOOKNO NUMBER PRIMARY KEY,
                        BOOKNAME VARCHAR2(20) NOT NULL,
                        AUTHORNO NUMBER,
                        PUBLISHERNO NUMBER,
                        FOREIGN KEY (AUTHORNO) REFERENCES DDRAUTHORTABLE(AUTHORNO),
                        FOREIGN KEY (PUBLISHERNO) REFERENCES DDRPUBLISHERTABLE(PUBLISHERNO),
                        COUNT NUMBER
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRBOOKNO_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRBOOKTABLE_TRG
                    BEFORE INSERT ON DDRBOOKTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.BOOKNO := DDRBOOKNO_SEQ.NEXTVAL;
                    END;
                """);

// 4. 장르-책 매핑 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRGENREBOOKTABLE(
                        GENRETABLENO NUMBER,
                        BOOKNO NUMBER,
                        PRIMARY KEY (GENRETABLENO, BOOKNO),
                        FOREIGN KEY (GENRETABLENO) REFERENCES DDRGENRETABLE(GENRETABLENO),
                        FOREIGN KEY (BOOKNO) REFERENCES DDRBOOKTABLE(BOOKNO)
                    )
                """);

// 5. 랜탈 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRRENTALTABLE (
                        RENTALNO NUMBER PRIMARY KEY,
                        BOOKNO NUMBER,
                        USERNO NUMBER,
                        RENTALSTARTDATE DATE DEFAULT SYSDATE,
                        RENTALENDDATE DATE DEFAULT SYSDATE + 7,
                        FOREIGN KEY (BOOKNO) REFERENCES DDRBOOKTABLE(BOOKNO),
                        FOREIGN KEY (USERNO) REFERENCES DDRUSERTABLE(USERNO)
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRRENTALTABLE_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRRENTALTABLE_TRG
                    BEFORE INSERT ON DDRRENTALTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.RENTALNO := DDRRENTALTABLE_SEQ.NEXTVAL;
                    END;
                """);

// 6. 장바구니 테이블 생성
        CreateTables.add("""
                    CREATE TABLE DDRSHSHOPPINGCARTTABLE (
                        SHOPPINGCARTNO NUMBER PRIMARY KEY,
                        BOOKNO NUMBER,
                        USERNO NUMBER,
                        FOREIGN KEY (BOOKNO) REFERENCES DDRBOOKTABLE(BOOKNO),
                        FOREIGN KEY (USERNO) REFERENCES DDRUSERTABLE(USERNO)
                    )
                """);
        CreateTables.add("""
                    CREATE SEQUENCE DDRSHSHOPPINGCART_SEQ
                    START WITH 1
                    INCREMENT BY 1
                    NOCACHE
                    NOCYCLE
                """);
        CreateTables.add("""
                    CREATE OR REPLACE TRIGGER DDRSHSHOPPINGCARTTABLE_TRG
                    BEFORE INSERT ON DDRSHSHOPPINGCARTTABLE
                    FOR EACH ROW
                    BEGIN
                        :NEW.SHOPPINGCARTNO := DDRSHSHOPPINGCART_SEQ.NEXTVAL;
                    END;
                """);

    }

    public static boolean executeUpdateSql(String sql, String url, String userid, String passwd) {
        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql); // SQL 실행
            System.out.println("SQL executed successfully: " + sql);
            return true;

        } catch (SQLException e) {
            System.err.println("SQL execution failed: " + sql);
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "scott";
        String passwd = "tiger";
        for (String sql : CreateTables) {
            executeUpdateSql(sql, url, userid, passwd);
        }
    }
}
