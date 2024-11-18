package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CgwSQL {
	public static ArrayList<Boolean> searchSqlType = new ArrayList<>(Arrays.asList(false, true));
	public static ArrayList<Boolean> allShowSqlType = new ArrayList<>(List.of(false));
	public static ArrayList<Boolean> top10ShowSqlType = new ArrayList<>(List.of(false));
	public static String allShowSql = """
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
			) THEN '대여불가'
			ELSE '대여가능'
			END AS IS_AVAILABLE
			FROM
			KBOOKTABLE B
			JOIN
			KAUTHORTABLE A ON B.AUTHORNO = A.AUTHORNO
			JOIN
			KPUBLISHERTABLE P ON B.PUBLISHERNO = P.PUBLISHERNO
			JOIN
			KGENREBOOKTABLE GB ON B.BOOKNO = GB.BOOKNO
			JOIN
			KGENRETABLE G ON GB.GENRETABLENO = G.GENRETABLENO
			GROUP BY
			B.BOOKNO, B.BOOKNAME, A.AUTHORNAME, P.PUBLISHERNAME
			ORDER BY
			B.BOOKNO
			""";
	public static String top10ShowSql = """
			SELECT LISTNO, BOOKNAME, AUTHORNAME, PUBLISHERNAME, GENRES, IS_AVAILABLE
			FROM (
			SELECT
			ROW_NUMBER() OVER (ORDER BY B.COUNT ASC) AS LISTNO,
			B.BOOKNAME,
			A.AUTHORNAME,
			P.PUBLISHERNAME,
			LISTAGG(G.GENRETABLENAME, ', ') WITHIN GROUP (ORDER BY G.GENRETABLENAME) AS GENRES,
			CASE
			WHEN EXISTS (
			SELECT 1
			FROM KRENTALTABLE R
			WHERE R.USERNO = ? AND R.BOOKNO = B.BOOKNO
			) THEN '대여불가'
			ELSE '대여가능'
			END AS IS_AVAILABLE,
			ROW_NUMBER() OVER (ORDER BY B.COUNT ASC) AS ROW_NUM
			FROM
			KBOOKTABLE B
			JOIN
			KAUTHORTABLE A ON B.AUTHORNO = A.AUTHORNO
			JOIN
			KPUBLISHERTABLE P ON B.PUBLISHERNO = P.PUBLISHERNO
			JOIN
			KGENREBOOKTABLE GB ON B.BOOKNO = GB.BOOKNO
			JOIN
			KGENRETABLE G ON GB.GENRETABLENO = G.GENRETABLENO
			GROUP BY
			B.BOOKNO, B.BOOKNAME, A.AUTHORNAME, P.PUBLISHERNAME, B.COUNT
			)
			WHERE ROW_NUM <= 10
			ORDER BY ROW_NUM
			""";

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
				) THEN '대여불가'
				ELSE '대여가능'
				END AS IS_AVAILABLE
				FROM
				KBOOKTABLE B
				JOIN
				KAUTHORTABLE A ON B.AUTHORNO = A.AUTHORNO
				JOIN
				KPUBLISHERTABLE P ON B.PUBLISHERNO = P.PUBLISHERNO
				JOIN
				KGENREBOOKTABLE GB ON B.BOOKNO = GB.BOOKNO
				JOIN
				KGENRETABLE G ON GB.GENRETABLENO = G.GENRETABLENO
				WHERE
				%s LIKE ?
				GROUP BY
				B.BOOKNO, B.BOOKNAME, A.AUTHORNAME, P.PUBLISHERNAME
				ORDER BY
				B.BOOKNO
				""";

		return String.format(searchSql, keyword);
	}

	public static String shoppingCartSql = """
			INSERT INTO KSHOPPINGCARTTABLE (BOOKNO, USERNO)
			SELECT ?, ?
			FROM DUAL
			WHERE NOT EXISTS (
			SELECT 1
			FROM KSHOPPINGCARTTABLE
			WHERE BOOKNO = ? AND USERNO = ?
			)
			""";

	public static ArrayList<Boolean> shoppingCartSqlType = new ArrayList<>(Arrays.asList(false, false, false, false));
}