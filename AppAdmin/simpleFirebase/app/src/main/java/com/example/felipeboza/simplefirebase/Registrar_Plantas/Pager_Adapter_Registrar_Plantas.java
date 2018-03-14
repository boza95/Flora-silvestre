package com.example.felipeboza.simplefirebase.Registrar_Plantas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Felipe Boza on 13/01/2018.
 */

public class Pager_Adapter_Registrar_Plantas extends FragmentStatePagerAdapter{

    int mNumOfTabs; // Numero de fragments que se tendran

    public Pager_Adapter_Registrar_Plantas(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        // Se llama a cada uno de los fragment

        switch (position)
        {
            case 0:

                Registrar_1_Frag reg1Fragment = new Registrar_1_Frag();
                return reg1Fragment;

            case 1:

                Registrar_2_Frag regPs2 = new Registrar_2_Frag();
                return regPs2;

            case 2:

                Registrar_3_Frag regPs3 = new Registrar_3_Frag();
                return regPs3;

            case 3:

                Registrar_4_Frag regPs4 = new Registrar_4_Frag();
                return regPs4;

            default:

                return null;
        }


    }

    @Override
    public CharSequence getPageTitle(int paramInt)
    {
        // Titulo que tendra cada fragment
        paramInt +=1;
        return "R"+paramInt;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
