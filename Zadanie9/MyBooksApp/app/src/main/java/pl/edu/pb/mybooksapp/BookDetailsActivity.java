package pl.edu.pb.mybooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {
    public static final String BOOK_DETAILS_TITLE = "pl.edu.pb.BOOK_DETAILS_TITLE";
    public static final String BOOK_DETAILS_AUTHOR = "pl.edu.pb.BOOK_DETAILS_AUTHOR";
    public static final String BOOK_DETAILS_SUBTITLE = "pl.edu.pb.BOOK_DETAILS_SUBTITLE";
    public static final String BOOK_DETAILS_PUBLISHER = "pl.edu.pb.BOOK_DETAILS_PUBLISHER";
    public static final String BOOK_DETAILS_COVER = "pl.edu.pb.BOOK_DETAILS_COVER";
    public static final String BOOK_DETAILS_PAGES = "pl.edu.pb.BOOK_DETAILS_PAGES";
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView subtitleTextView;
    private TextView publisherTextView;
    private TextView pagesTextView;
    private ImageView bookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        authorTextView = findViewById(R.id.book_author);
        titleTextView = findViewById(R.id.book_title);
        subtitleTextView = findViewById(R.id.book_subtitle);
        bookCover= findViewById(R.id.img_cover);
        publisherTextView = findViewById(R.id.book_publisher);
        pagesTextView = findViewById(R.id.book_pages);

        Intent intent = getIntent();
        titleTextView.setText(intent.getStringExtra(BOOK_DETAILS_TITLE));
        authorTextView.setText(intent.getStringExtra(BOOK_DETAILS_AUTHOR));
        subtitleTextView.setText(intent.getStringExtra(BOOK_DETAILS_SUBTITLE));
        publisherTextView.setText(intent.getStringExtra(BOOK_DETAILS_PUBLISHER));
        pagesTextView.setText(intent.getStringExtra(BOOK_DETAILS_PAGES));
        String cover = intent.getStringExtra(BOOK_DETAILS_COVER);

        if(cover != null){
            Picasso.with(this)
                    .load(MainActivity.IMAGE_URL_BASE+cover+"-L.jpg")
                    .placeholder(R.drawable.book_icon)
                    .into(bookCover);
        }else{
            bookCover.setImageResource(R.drawable.book_icon);
        }
    }
}
