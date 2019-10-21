package com.app.roomy.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.solver.widgets.Helper
import com.app.roomy.R
import com.app.roomy.util.HelperUtil
import com.app.roomy.view.uiConfig.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.house_bed_info.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        fullscreenActivity()
        setContentView(R.layout.activity_detail)
        fakeBeds()
        txtHouseDeposit.text=" ودیعه (رهن) : "+HelperUtil().convertPriceToFormattedPrice(500000)
       txtHousePrice.text=" اجاره ماهانه : "+ HelperUtil().convertPriceToFormattedPrice(350000)
    }

    private fun fakeBeds()
    {
        for (i in 1..10)
        {
            var bedView=layoutInflater.inflate(R.layout.house_detail_bed_item,null)

            var txtHouseBedTypeTitle=bedView.findViewById<TextView>(R.id.txtHouseBedTypeTitle)
            var txtHouseBedPrice=bedView.findViewById<TextView>(R.id.txtHouseBedPrice)

            txtHouseBedTypeTitle.text="تخت"+i.toString()
            txtHouseBedPrice.text="قیمت"+i.toString()

            containerBedInfo.addView(bedView)
        }
       /* for (int i = 0; i < response.body().BedInfo.size(); i++)
        {
           var myView

            View inflatedView = getLayoutInflater().inflate(R.layout.house_detail_bed_item, null);

            TextView txtHouseBedTypeTitle = inflatedView.findViewById(R.id.txtHouseBedTypeTitle);
            TextView txtHouseBedPrice = inflatedView.findViewById(R.id.txtHouseBedPrice);

            txtHouseBedTypeTitle.setText(response.body().BedInfo.get(i).BedTypeTitle);
            txtHouseBedPrice.setText(response.body().BedInfo.get(i).BedTypePrice + " تومان ");

            containerBedInfo.addView(inflatedView);
        } */
    }
}
