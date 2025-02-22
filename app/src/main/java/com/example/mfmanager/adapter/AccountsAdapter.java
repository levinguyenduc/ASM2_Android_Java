package com.example.mfmanager.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.mfmanager.R;
import com.example.mfmanager.database.AccountsTable;
import com.example.mfmanager.tools.CurrencyFormatter;

public class AccountsAdapter extends CursorAdapter{

    Context mContext;

    public AccountsAdapter(Context context, Cursor cursor, int flag){
        super(context, cursor, flag);
        mContext = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.accounts_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(AccountsTable.COL2));
        String type = cursor.getString(cursor.getColumnIndex(AccountsTable.COL3));
        String balance = cursor.getString(cursor.getColumnIndex(AccountsTable.COL5));

        TextView accountName = view.findViewById(R.id.account_item_name);
        TextView accountType = view.findViewById(R.id.account_item_type);
        TextView accountBalance = view.findViewById(R.id.account_item_balance);

        accountName.setText(name);
        accountType.setText(type);
        accountBalance.setText(CurrencyFormatter.format(mContext, balance));

    }


}