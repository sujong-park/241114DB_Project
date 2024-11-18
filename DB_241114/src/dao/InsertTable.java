package dao;

<<<<<<< HEAD

import java.sql.*;
=======
>>>>>>> refs/heads/middle
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertTable {
	public static ArrayList<String> InsertData = new ArrayList<>();

// 작가 이름 리스트
	public static ArrayList<String> authors = new ArrayList<>(
			Arrays.asList("J.K. Rowling", "George R.R. Martin", "Stephen King", "Agatha Christie", "J.R.R. Tolkien",
					"Haruki Murakami", "Jane Austen", "Mark Twain", "Charles Dickens", "Leo Tolstoy",
					"Fyodor Dostoevsky", "Ernest Hemingway", "Gabriel Garcia Marquez", "Franz Kafka", "Victor Hugo",
					"Arthur Conan Doyle", "Isaac Asimov", "Edgar Allan Poe", "Oscar Wilde", "H.P. Lovecraft"));

<<<<<<< HEAD
        // 작가 테이블 데이터 20개
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
        InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('Anne Rice')");
=======
// 출판사 이름 리스트
	public static ArrayList<String> publishers = new ArrayList<>(Arrays.asList("Penguin Random House", "HarperCollins",
			"Simon & Schuster", "Hachette Book Group", "Macmillan Publishers", "Scholastic", "Oxford University Press",
			"Pearson", "Bloomsbury Publishing", "Cengage", "Wiley", "Springer", "Elsevier", "Vintage Books",
			"Pan Macmillan", "DK Publishing", "Tor Books", "Bantam Books", "Little, Brown and Company", "Ecco Press"));
>>>>>>> refs/heads/middle

<<<<<<< HEAD
        // 출판사 테이블 데이터 15개
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
        InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('Bloomsbury Publishing')");
=======
// 장르 이름 리스트
	public static ArrayList<String> genres = new ArrayList<>(
			Arrays.asList("Fantasy", "Science Fiction", "Mystery", "Thriller", "Romance", "Historical Fiction",
					"Horror", "Biography", "Self-Help", "Poetry", "Non-Fiction", "Adventure", "Graphic Novel",
					"Children Literature", "Young Adult", "Classic", "Crime", "Drama", "Philosophy", "Short Stories"));
>>>>>>> refs/heads/middle

<<<<<<< HEAD
        // 장르 테이블 데이터 10개
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
=======
	public static ArrayList<String> bookTitles = new ArrayList<>(Arrays.asList("The Shadow of Eternity",
			"Whispers of the Wind", "Beneath the Crimson Sky", "Echoes of the Forgotten", "The Last Enigma",
			"Shattered Reflections", "A Symphony of Stars", "Wanderlust Chronicles", "The Keeper of Secrets",
			"The Alchemist Code", "Threads of Destiny", "A Kingdom of Ashes", "The Edge of Tomorrow",
			"Dreams of the Unknown", "The Sands of Time", "Mysteries of the Deep", "The Forgotten Voyage",
			"Fate Redemption", "Legacy of the Fallen", "Labyrinth of Lies", "A Whisper of Shadows",
			"The Midnight Tides", "Echoes in the Abyss", "The Eternal Flame", "The Hidden Chronicle",
			"Secrets of the Oracle", "Winds of Change", "The Iron Citadel", "The Pale Horizon", "A Tale of Two Worlds",
			"The Clockwork Kingdom", "The Starbound Heir", "A Mirror of Ice", "The Vanished Realm", "The Phoenix Rise",
			"Tales of the Moonlit Path", "The Crimson Throne", "The Silent Kingdom", "The Wanderer Compass",
			"A Dance of Blades", "The Emerald Prophecy", "Voices of the Ancients", "A Path of Thorns",
			"The Shimmering Veil", "The Spiral Staircase", "The Lost Symphony", "The Golden Labyrinth",
			"The Winter Heir", "Shadows of the Past", "The Rising Storm", "A Legacy in Flames",
			"The Forgotten Prophecy", "The Stolen Crown", "The Lantern Glow", "The Silver Masquerade",
			"A Whisper in the Dark", "The Final Odyssey", "The Mystic Journey", "The Cursed Kingdom",
			"The Merchant Tale", "The Enchanted Hourglass", "A Rift in Time", "The Binding Curse",
			"Chronicles of the Silent Woods", "The Seeker Light", "A Symphony of Shadows", "The Starborn Chronicles",
			"The Warden Oath", "The Spiral of Fate", "The Glass Horizon", "The Veil of Dreams", "The Crimson Seal",
			"A Cloak of Feathers", "The Eternal Voyage", "The Sapphire Song", "A Kingdom for the Lost",
			"The Nightwatcher Gambit", "The Ashen Crown", "The Whispering Forest", "The Warlock Gambit",
			"The Moonlit Haven", "The Horizon of Echoes", "The Storm Embrace", "The Ivory Key", "The Harbinger Call",
			"The Forgotten Tides", "The Sky Edge", "The Gilded Cage", "The Obsidian Mirror", "The Silent Passage",
			"A World Apart", "The Path of Echoes", "The Last Sanctuary", "The Specter Grasp", "The Eternal Spire",
			"The Shattered Kingdom", "The Shadow Edge", "The Lunar Tapestry", "The Fractured Realm"));
>>>>>>> refs/heads/middle

<<<<<<< HEAD
        // 책 테이블 데이터 50개
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
=======
	static {
		for (String authorName : authors) {
			InsertData.add("INSERT INTO KAUTHORTABLE (AUTHORNAME) VALUES ('" + authorName + "')");
		}
		for (String publisherName : publishers) {
			InsertData.add("INSERT INTO KPUBLISHERTABLE (PUBLISHERNAME) VALUES ('" + publisherName + "')");
		}
		for (String genreName : genres) {
			InsertData.add("INSERT INTO KGENRETABLE (GENRETABLENAME) VALUES ('" + genreName + "')");
		}
		Random rand = new Random();
		int inputIndex = 1;
		int appendInt = 1;
		for (int i = 1; i <= bookTitles.size(); i++) {
			int randomCountInt = rand.nextInt(56);
			InsertData.add("INSERT INTO KBOOKTABLE (BOOKNAME, AUTHORNO, PUBLISHERNO, COUNT) VALUES ('"
					+ bookTitles.get(i - 1) + "', " + inputIndex + ", " + inputIndex + ", " + randomCountInt + ")");
			InsertData.add("INSERT INTO KGENREBOOKTABLE (GENRETABLENO, BOOKNO) VALUES (" + inputIndex + ", " + i + ")");
			inputIndex += appendInt;
			if (inputIndex == 20) {
				appendInt = -1;
			}
			if (inputIndex == 1) {
				appendInt = 1;
			}
		}
	}

	public static void inputData() {
		for (String sql : InsertData) {
			CgwDAO.executeUpdateSql(sql);
		}
	}
>>>>>>> refs/heads/middle

<<<<<<< HEAD
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
=======
	public static void main(String[] args) {
		inputData();
	}
>>>>>>> refs/heads/middle
}