package com.example.technicise.shabdo_khoj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity
{
    private static final int CHOOSE_FILE_REQUESTCODE = 0x1;
    private List<String> item = null;

    private List<String> path = null;

    private String root="/";

    private TextView myPath;

    public ListView LvRemindersTab;
    ArrayList<String> dataArray;
    CustomBaseAdapterForChartListLocalValues listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LvRemindersTab = (ListView)findViewById(R.id.ListView_Home_Screen_Tab);
//        dataArray = new ArrayList<String>();
//        dataArray.add(0,"hello1");
//        dataArray.add(1,"hello2");
//        dataArray.add(2,"hello3");
//
//        listAdapter	= new CustomBaseAdapterForChartListLocalValues(getApplicationContext(), dataArray);
//        LvRemindersTab.setAdapter( listAdapter );

//        /**
//         * Callback for data list reading.
//         */
//        @Override
//        public void onReadyDataList() {
//        listAdapter.notifyData();
//    }
//
//    };

//    json.fetchJSON(null);
//    ListViewSwipeGesture touchListener = new ListViewSwipeGesture( LvRemindersTab, this.touchListener, getActivity());
//    touchListener.SwipeType	= ListViewSwipeGesture.Double; //Set two options at background of list item
//    LvRemindersTab.setOnTouchListener(touchListener);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void browseAndAddFiles(View v)
    {
        //getDir(root);
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("*/*");
        startActivityForResult(intent, CHOOSE_FILE_REQUESTCODE);
    }

//    private void getDir(String dirPath)
//    {
//
//        //myPath.setText("Location: " + dirPath);
//
//
//
//        item = new ArrayList<String>();
//
//        path = new ArrayList<String>();
//
//
//
//        File f = new File(dirPath);
//
//        File[] files = f.listFiles();
//
//
//
//        if(!dirPath.equals(root))
//
//        {
//            item.add(root);
//
//            path.add(root);
//
//            item.add("../");
//
//            path.add(f.getParent());
//
//        }
//
//
//        for(int i=0; i < files.length; i++)
//
//        {
//
//            File file = files[i];
//
//            path.add(file.getPath());
//
//            if(file.isDirectory())
//
//                item.add(file.getName() + "/");
//
//            else
//
//                item.add(file.getName());
//
//        }
//
//
//
//        ArrayAdapter<String> fileList =
//
//                new ArrayAdapter<String>(this, R.layout.row, item);
//
//        //setListAdapter(fileList);
//
//    }

    // This is the onActivityResult method definition for this activity class. It takes one requestCode parameter which matches
    // to always RESULT_OK and one requestCode and the an intent. These intent and requestCode value are matched from the CROP,
    // GALLERY or CAMERA methods and with respect to these values the different switch statements are being executed.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != RESULT_OK)
        {
            return;
        }

        Bitmap bitmap;

        switch (requestCode)
        {
            case CHOOSE_FILE_REQUESTCODE:
                try
                {
//                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
//                    FileOutputStream fileOutputStream = new FileOutputStream(mFileTemp);
//                    copyStream(inputStream, fileOutputStream);
//                    fileOutputStream.close();
//                    inputStream.close();
//
//                    startCropImage();
                    String dataValue= data.getDataString();
                    //String dataType= data.getType();
                    Toast.makeText(getApplicationContext(), "Selected file name is "+dataValue, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Data type "+dataType, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    //Log.e(TAG, "Error while creating temp file", e);
                }
                break;

//            case REQUEST_CODE_TAKE_PICTURE:
//                startCropImage();
//                break;
//
//            case REQUEST_CODE_CROP_IMAGE:
//                String path = data.getStringExtra(CropImage.IMAGE_PATH);
//                if (path == null)
//                {
//                    return;
//                }
//                saveButton.setVisibility(View.VISIBLE);
//                bitmap = BitmapFactory.decodeFile(mFileTemp.getPath());
//
//                // stores the image with this bitmap and to this filename.
//                storeImage((bitmap),filename);
//                mImageView.setImageBitmap(bitmap);
//
//                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
