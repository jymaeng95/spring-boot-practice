package zayson.java.lab.kotlin.grammer.lecture14

sealed class NexonGames (
    val name: String,
    val year: Int
)

// 상속
class MapleStory : NexonGames("메이플 스토리", 2003)

class FifaOnline4 : NexonGames("피파 온라인 4", 2018)
