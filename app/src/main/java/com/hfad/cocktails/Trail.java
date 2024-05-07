package com.hfad.cocktails;

public class Trail {
    private String name;
    private String description;
    private int imageResourceId;

    public Trail(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Trail[] summerTrails = {
            new Trail("Szlak na Rysy", "Najwyższy szczyt w Polsce oferuje spektakularne widoki i wymagające podejście przez skaliste partie Tatr.", R.drawable.szlak_rysy),
            new Trail("Szlak na Świnicę", "Prowadzi na jeden z charakterystycznych szczytów Tatr Zachodnich, oferując widoki na Tatry oraz okoliczne doliny.", R.drawable.szlak_swinice),
            new Trail("Szlak Gór Stołowych", "Przebiega przez magiczne formacje skalne i skalne labirynty Gór Stołowych, oferując niepowtarzalne doznania wśród kamienistej przyrody.", R.drawable.szlak_stolowe),
            new Trail("Szlak Orłowicza", "Przebiega przez jedne z najpiękniejszych i najdzikszych obszarów Bieszczadów, oferując widoki na dziką przyrodę i unikatowe krajobrazy.", R.drawable.szlak_orlowicza),
            new Trail("Szlak na Trzy Korony", "To popularny szlak prowadzący na jeden z najwyższych szczytów Pienińskiego Parku Narodowego, z zapierającymi dech widokami na Dunajec i okoliczne pasma.", R.drawable.szlak_trzy),
            new Trail("Szlak Świętokrzyski", "Przebiega przez malownicze krajobrazy Gór Świętokrzyskich, oferując możliwość podziwiania unikalnej przyrody oraz historycznych zabytków.", R.drawable.szlak_swietokrzyski)
    };

    public static final Trail[] winterTrails = {
            new Trail("Szlak na Kasprowy Wierch", "Popularna trasa narciarska oferująca niezapomniane wrażenia z jazdy na nartach oraz widoki na ośnieżone Tatry.", R.drawable.szlak_kasprowy),
            new Trail("Szlak na Skrzyczne", "Prowadzi na najwyższy szczyt Beskidów Zachodnich, oferując możliwość doświadczenia zimowej przyrody Beskidów oraz wspaniałe widoki na okoliczne góry.", R.drawable.szlak_skrzyczne),
            new Trail("Szlak na Śnieżkę", "Wymagająca trasa zimowa prowadząca na najwyższy szczyt Karkonoszy, oferująca widoki na zimowe krajobrazy i niezwykłe doświadczenia.", R.drawable.szlak_sniezka),
            new Trail("Szlak na Babia Górę", "Babia Góra jest jednym z najważniejszych szczytów Beskidu Żywieckiego. Zimą szlak oferuje piękne widoki na okoliczne góry oraz doznania związane z zimowymi wędrówkami w górach.", R.drawable.szlak_babia),
            new Trail("Szlak na Śnieżnik", "Prowadzi na najwyższy szczyt Gór Opawskich, oferując niezapomniane widoki na otaczające krajobrazy oraz bogactwo przyrody.", R.drawable.szlak_snieznik),
            new Trail("Szlak Beskidu Śląskiego", "Szlak Beskidzki to popularna trasa górska w Beskidach, zapewniająca wspaniałe widoki na górskie krajobrazy i bogatą kulturę góralską.", R.drawable.szlak_beskid)
    };

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }


}