package dao;

import java.util.ArrayList;
import java.util.Arrays;

public class CgwSQL {
    public static ArrayList<Boolean> searchSqlType = new ArrayList<>(Arrays.asList(false, true));

    public static String getSearchSql(String keyword) {
        String searchSql = """
                SELECT
                    B.BOOKNO,
                    B.BOOKNAME,
                    A.AUTHORNAME,
                    P.PUBLISHERNAME,
                    LISTAGG(G.GENRETABLENAME, ', ') WITHIN GROUP (ORDER BY G.GENRETABLENAME) AS GENRES,
                    CASE
                        WHEN EXISTS (
                            SELECT 1
                            FROM KRENTALTABLE R
                            WHERE R.USERNO = ? AND R.BOOKNO = B.BOOKNO
                        ) THEN 'FALSE'
                        ELSE 'TRUE'
                    END AS IS_AVAILABLE
                FROM
                    KBOOKTABLE B
                JOIN
                    KAUTHORTABLE A ON B.AUTHORNO = A.AUTHORNO
                JOIN
                    KPUBLISHERTABLE P ON B.PUBLISHERNO = P.PUBLISHERNO
                JOIN
                    KGENRETABLE G ON B.BOOKNO = G.GENRETABLENO
                WHERE
                    %s LIKE ?
                GROUP BY
                    B.BOOKNO, B.BOOKNAME, A.AUTHORNAME, P.PUBLISHERNAME
                ORDER BY
                    B.BOOKNO
                """;

        return String.format(searchSql, keyword);
    }
}
