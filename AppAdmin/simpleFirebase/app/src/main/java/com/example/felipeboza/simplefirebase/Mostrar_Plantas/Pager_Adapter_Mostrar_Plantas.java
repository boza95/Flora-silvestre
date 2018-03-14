package com.example.felipeboza.simplefirebase.Mostrar_Plantas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.felipeboza.simplefirebase.Modificar_Plantas.Modificar_1_Frag;
import com.example.felipeboza.simplefirebase.Modificar_Plantas.Modificar_2_Frag;
import com.example.felipeboza.simplefirebase.Modificar_Plantas.Modificar_3_Frag;
import com.example.felipeboza.simplefirebase.Modificar_Plantas.Modificar_4_Frag;

/**
 * Created by Felipe Boza on 21/01/2018.
 */

public class Pager_Adapter_Mostrar_Plantas extends FragmentStatePagerAdapter {

    int mNumOfTabs; // Numero de fragments que se tendran

    public Pager_Adapter_Mostrar_Plantas(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        // Se llama a cada uno de los fragment

        switch (position)
        {
            case 0:

                Mostrar_1_Frag mos1Fragment = new Mostrar_1_Frag();
                return mos1Fragment;

            case 1:

                Mostrar_2_Frag mos2Fragment = new Mostrar_2_Frag();
                return mos2Fragment;

            case 2:

                Mostrar_3_Frag mos3Fragment = new Mostrar_3_Frag();
                return mos3Fragment;

            case 3:

                Mostrar_4_Frag mos4Fragment = new Mostrar_4_Frag();
                return mos4Fragment;

            default:

                return null;
        }


    }

    @Override
    public CharSequence getPageTitle(int paramInt)
    {
        // Titulo que tendra cada fragment
        paramInt +=1;
        return "I"+paramInt;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

