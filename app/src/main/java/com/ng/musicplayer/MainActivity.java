package com.ng.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private ProgressBar mProgessBarMiniPLayer;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private LibraryFragment libraryFragment;
    private AccountFragment accountFragment;

    private PlaylistDetailsFragment playlistDetailsFragment;
    private TextView mTvSongName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.w);
        setContentView(R.layout.activity_main);

        mMainFrame = findViewById(R.id.main_frag_layout);
        mMainNav = findViewById(R.id.main_nav);
        mTvSongName = findViewById(R.id.tv_song_name);
        mProgessBarMiniPLayer = findViewById(R.id.progessbar_music);

        mProgessBarMiniPLayer.setProgress(50);

        //make text running
        mTvSongName.setSelected(true);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        libraryFragment = new LibraryFragment();
        accountFragment = new AccountFragment();

        playlistDetailsFragment = new PlaylistDetailsFragment();
        setFragmentTo((homeFragment));
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        setFragmentTo(homeFragment);
                        return true;
                    case R.id.nav_search:
                        setFragmentTo(searchFragment);
                        return true;
                    case  R.id.nav_library:
                        setFragmentTo(libraryFragment);
                        return true;
                    case R.id.nav_acc:
                        setFragmentTo(playlistDetailsFragment);
                        return true;
                        default:return false;
                }
                            }
        });
    }
    private void  setFragmentTo(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frag_layout, fragment);
        fragmentTransaction.commit();
    }
}
