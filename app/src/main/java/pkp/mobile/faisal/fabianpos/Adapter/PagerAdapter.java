package pkp.mobile.faisal.fabianpos.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import pkp.mobile.faisal.fabianpos.FragmentMasters.MasterFloorsFragment;
import pkp.mobile.faisal.fabianpos.FragmentMasters.MasterTablesFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int pageCount = 2;
    private String tabTitles[] = new String[]{
            "Floor",
            "Table",
    };

    private Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MasterFloorsFragment tab1 = new MasterFloorsFragment();
                return tab1;
            case 1:
                MasterTablesFragment tab2 = new MasterTablesFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return tabTitles[position];
        // Generate title based on item position
//        Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
//
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
        return tabTitles[position];
        // return tabTitles[position];
    }
}