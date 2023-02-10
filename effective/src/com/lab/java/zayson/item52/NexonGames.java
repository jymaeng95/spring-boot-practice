package com.lab.java.zayson.item52;

public class NexonGames {
    String title() {
        return "넥슨 게임";
    }
}

class MapleStory extends NexonGames {
    @Override
    String title() {
        return "메이플스토리";
    }
}

class FifaOnline4 extends NexonGames {
    @Override
    String title() {
        return "피파온라인 4";
    }
}
