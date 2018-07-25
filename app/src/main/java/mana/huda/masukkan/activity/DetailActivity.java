package mana.huda.masukkan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mana.huda.masukkan.R;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvIssue, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvIssue = (TextView) findViewById(R.id.tvIssue);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String issue = intent.getStringExtra("issue");
        String status = intent.getStringExtra("status");

        tvTitle.setText(title);
        tvIssue.setText(issue);
        tvStatus.setText(status);

    }
}
