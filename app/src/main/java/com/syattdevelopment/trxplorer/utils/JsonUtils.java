package com.syattdevelopment.trxplorer.utils;

import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.models.accounts.Account;
import com.syattdevelopment.trxplorer.models.accounts.AccountData;
import com.syattdevelopment.trxplorer.models.blocks.Block;
import com.syattdevelopment.trxplorer.models.blocks.BlockData;
import com.syattdevelopment.trxplorer.models.blocks.BlockSize;
import com.syattdevelopment.trxplorer.models.blocks.BlockSizeData;
import com.syattdevelopment.trxplorer.models.tokens.Token;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    public static int determineParse(String url) {
        switch (url) {
            case APIS.RECENT_BLOCKS_URL:
                return 0;
            case APIS.RECENT_TRANSFERS_URL:
                return 1;
            case APIS.TRON_PRICE_URL:
                return 2;
            case APIS.NODE_MAP_URL:
                return 3;
            case APIS.TRANSACTIONS_LAST_HOUR:
                return 4;
            case APIS.BLOCKS_URL:
                return 5;
            case APIS.TRANSACTIONS_URL:
                return 6;
            case APIS.TRANSFERS_URL:
                return 7;
            case APIS.ACCOUNTS_URL:
                return 8;
            case APIS.NODES_URL:
                return 9;
            case APIS.REPS_URL:
                return 10;
            case APIS.OVERVIEW_URL:
                return 11;
            case APIS.AVERAGE_PRICE_URL:
                return 12;
            case APIS.AVERAGE_VOLUME_URL:
                return 13;
            case APIS.MARKETS_URL:
                return 14;
            case APIS.CURRENT_CYCLE_URL:
                return 15;
            case APIS.NEXT_CYCLE_URL:
                return 16;
            case APIS.SYSTEM_URL:
                return 17;
            case APIS.BLOCK_SIZE_URL:
                return 18;
            default:
                return 0;
        }
    }

    private static Block parseBlock(JSONObject blockJson) throws JSONException {
        Block block = new Block();
        block.setNumber(blockJson.getInt("number"));
        block.setHash(blockJson.getString("hash"));
        block.setSize(blockJson.getInt("size"));
        block.setTimestamp(blockJson.getInt("timestamp"));
        block.setTxTrieRoot(blockJson.getString("txTrieRoot"));
        block.setParentHash(blockJson.getString("parentHash"));
        block.setWitnessId(blockJson.getInt("witnessId"));
        block.setWitnessAddress(blockJson.getString("witnessAddress"));
        block.setNrOfTx(blockJson.getInt("nrOfTrx"));
        block.setConfirmed(blockJson.getBoolean("confirmed"));
        return block;
    }

    private static Account parseAccount(JSONObject accountJson) throws JSONException {
        Account account = new Account();
        account.setAddress(accountJson.getString("account"));
        account.setName(accountJson.getString("name"));
        account.setBalance(accountJson.getInt("balance"));
        account.setPower(accountJson.getInt("balance"));
        account.setDateCreated(accountJson.getInt("dateCreated"));
        account.setDateUpdated(accountJson.getInt("dateUpdated"));
        return account;
    }

    private static BlockData parseBlockData(String response) {
        BlockData blockData = new BlockData();
        try {
            JSONObject root = new JSONObject(response);
            int total = root.getInt("total");
            blockData.setTotal(total);

            JSONArray data = root.getJSONArray("data");
            ArrayList<Block> blocks = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                JSONObject blockJson = data.getJSONObject(i);
                blocks.add(parseBlock(blockJson));
            }

            blockData.setData(blocks);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return blockData;
    }

    private static AccountData parseAccountData(String response) {
        AccountData accountData = new AccountData();
        try {
            JSONObject root = new JSONObject(response);
            int total = root.getInt("total");
            accountData.setTotal(total);

            JSONArray data = root.getJSONArray("data");
            ArrayList<Account> accounts = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                JSONObject accountJson = data.getJSONObject(i);
                accounts.add(parseAccount(accountJson));
            }

            accountData.setData(accounts);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return accountData;
    }

    private static BlockSizeData parseBlockSizeData(String response) {
        BlockSizeData blockSizeData = new BlockSizeData();
        ArrayList<BlockSize> data = new ArrayList<>();

        try {
            JSONArray root = new JSONArray(response);
            for (int i = 0; i < root.length(); i++) {
                JSONObject jsonObject = root.getJSONObject(i);
                BlockSize blockSize = new BlockSize();
                blockSize.setTimestamp(jsonObject.getInt("timestamp"));
                blockSize.setValue(jsonObject.getInt("value"));
                data.add(blockSize);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        blockSizeData.setTotal(data.size());
        blockSizeData.setData(data);
        return blockSizeData;
    }

    public static Object parseData(String response, int code) {
        switch (code) {
            case 5:
                return parseBlockData(response);
            case 8:
                return parseAccountData(response);
            case 18:
                return parseBlockSizeData(response);
            default:
                return null;
        }
    }
}
