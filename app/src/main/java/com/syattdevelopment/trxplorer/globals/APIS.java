package com.syattdevelopment.trxplorer.globals;

public class APIS {
    public static final String RECENT_BLOCKS_URL = "https://api.tronscan.org/api/block?sort=-number&limit=15&count=true&order=-timestamp";
    public static final String RECENT_TRANSFERS_URL = "https://api.tronscan.org/api/transfer?sort=-timestamp&limit=10";
    public static final String TRON_PRICE_URL = "https://api.coinmarketcap.com/v1/ticker/tronix/?convert=";
    public static final String NODE_MAP_URL = "https://api.tronscan.org/api/nodemap";
    public static final String TRANSACTIONS_LAST_HOUR = "https://api.tronscan.org/api/transfer/stats?groupby=timestamp&interval=hour";
    public static final String BLOCKS_URL = "https://api.tronscan.org/api/block?sort=-number&limit=25&count=true&start=";
    public static final String TRANSACTIONS_URL = "https://api.tronscan.org/api/transaction?sort=-timestamp&count=true&limit=25&start=";
    public static final String TRANSFERS_URL = "https://api.tronscan.org/api/transfer?sort=-timestamp&count=true&limit=25&start=";
    public static final String ACCOUNTS_URL = "https://api.tronscan.org/api/account?sort=-balance&limit=25&start=";
    public static final String NODES_URL = "https://api.tronscan.org/api/node";
    public static final String REPS_URL = "https://api.tronscan.org/api/witness";
    public static final String OVERVIEW_URL = "https://api.tronscan.org/api/token?sort=-name&limit=25&start=";
    public static final String AVERAGE_PRICE_URL = "https://min-api.cryptocompare.com/data/histoday?fsym=TRX&tsym=USD&limit=10";
    public static final String AVERAGE_VOLUME_URL = "https://min-api.cryptocompare.com/data/exchange/histohour?fsym=TRX&tsym=USD&limit=10";
    public static final String MARKETS_URL = "https://api.tronscan.org/api/market/markets";
    public static final String CURRENT_CYCLE_URL = "https://api.tronscan.org/api/vote/current-cycle";
    public static final String NEXT_CYCLE_URL = "https://api.tronscan.org/api/vote/next-cycle";
    public static final String SYSTEM_URL = "https://api.tronscan.org/api/system/status";
    public static final String BLOCK_SIZE_URL = "https://api.tronscan.org/api/block/stats?info=avg-block-size";
}
