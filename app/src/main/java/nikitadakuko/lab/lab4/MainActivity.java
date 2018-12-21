package nikitadakuko.lab.lab4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_view, menu);
        return true;
    }


        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_frag_1:

                new AlertDialog.Builder(this)
                        .setTitle("Are you sure?")
                        .setMessage("Do you really want to move to fragment 1?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getApplicationContext(), "nav to frag 1", Toast.LENGTH_SHORT).show();
                                viewPager.setCurrentItem(0);
                            }})

                        .setNegativeButton(android.R.string.no, null).show();

                return true;

            case R.id.nav_frag_2:

                new AlertDialog.Builder(this)
                        .setTitle("Are you sure?")
                        .setMessage("Do you really want to move to fragment 2?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getApplicationContext(), "nav to frag 1", Toast.LENGTH_SHORT).show();
                                viewPager.setCurrentItem(1);
                            }})

                        .setNegativeButton(android.R.string.no, null).show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
