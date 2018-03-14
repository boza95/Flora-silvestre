package com.example.felipeboza.simplefirebase.Modificar_Plantas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Felipe Boza on 20/01/2018.
 */
public class Pager_Adapter_Modificar_Plantas extends FragmentStatePagerAdapter{

    int mNumOfTabs; // Numero de fragments que se tendran

    public Pager_Adapter_Modificar_Plantas(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        // Se llama a cada uno de los fragment

        switch (position)
        {
            case 0:

                Modificar_1_Frag mod1Fragment = new Modificar_1_Frag();
                return mod1Fragment;

            case 1:

                Modificar_2_Frag mod2Fragment = new Modificar_2_Frag();
                return mod2Fragment;

            case 2:

                Modificar_3_Frag mod3Fragment = new Modificar_3_Frag();
                return mod3Fragment;

            case 3:

                Modificar_4_Frag mod4Fragment = new Modificar_4_Frag();
                return mod4Fragment;

            default:

                return null;
        }


    }

    @Override
    public CharSequence getPageTitle(int paramInt)
    {
        // Titulo que tendra cada fragment
        paramInt +=1;
        return "M"+paramInt;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
