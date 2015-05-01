package com.example.technicise.shabdo_khoj;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.example.technicise.shabdo_khoj.swipehelpercalasses.ListAdapter;
import com.example.technicise.shabdo_khoj.swipehelpercalasses.ListViewSwipeGesture;
import com.example.technicise.shabdo_khoj.swipehelpercalasses.dumpclass;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity
{
    private static final int CHOOSE_FILE_REQUESTCODE = 0x1;

    private ListView cmn_list_view;
    private ListAdapter listAdapter;
    private ArrayList<dumpclass> listdata;

    //ArrayList thats going to hold the search results
    ArrayList<HashMap<String, Object>> searchResults;
    //ArrayList that will hold the original Data
    ArrayList<HashMap<String, Object>> originalValues;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //searchResults=new ArrayList<HashMap<String,Object>>(originalValues);
        originalValues = new ArrayList<HashMap<String, Object>>();

        cmn_list_view	=	(ListView) findViewById(R.id.cmn_list_view);
        listdata		=	new ArrayList<dumpclass>();
        InitializeValues();
        ListViewSwipeGesture touchListener = new ListViewSwipeGesture(
                cmn_list_view, swipeListener, this);
        touchListener.SwipeType	=	ListViewSwipeGesture.Double;    //Set two options at background of list item

        cmn_list_view.setOnTouchListener(touchListener);

    }

    private void InitializeValues()
    {

        listAdapter		=	new ListAdapter(this, listdata);
        cmn_list_view.setAdapter(listAdapter);
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

                    //String dataUri = data.getDataString();

                    //get file uri or location in device
                    Uri returnUri = data.getData();

                    // file type: i.e.- image/png or video/mp4
                    String dataType= getContentResolver().getType(returnUri);

                    Cursor returnCursor =
                            getContentResolver().query(returnUri, null, null, null, null);
                    /*
                     * Get the column indexes of the data in the Cursor,
                     * move to the first row in the Cursor, get the data,
                     * and display it.
                     */
                    //file name index
                    int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    //file size index
                    int sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);

                    returnCursor.moveToFirst();
                    //file name
                    String fileName=returnCursor.getString(nameIndex);

                    //file size
                    long fileSizeInByte=returnCursor.getLong(sizeIndex);
                    long fileSizeInKb=fileSizeInByte/(1024);
                    //String fileSize=Long.toString(fileSizeInMb);

                    String DisplayText="DATA TYPE: "+dataType+" NAME: "+fileName+" SIZE: "+fileSizeInKb+" K";

                    listdata.add(new dumpclass(returnUri +"",dataType+""));
                    listAdapter.notifyDataSetChanged();
                    //Toast.makeText(getApplicationContext(), "Data type "+dataType, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    ListViewSwipeGesture.TouchCallbacks swipeListener = new ListViewSwipeGesture.TouchCallbacks() {

        @Override
        public void FullSwipeListView(int position) {
            Toast.makeText(getApplicationContext(), "Tags functionality coming soon", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void FullSwipeListView2(int position) {
            Toast.makeText(getApplicationContext(), "Index functionality coming soon", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void HalfSwipeListView(int position)
        {
            String filepath=null;

            Object clickedItem = listAdapter.getItem(position);
            Class c=clickedItem.getClass();
//            String value;
//            String a= String.valueOf(clickedItem.get(0));
            //String caption = (String) clickedItem.Get(ITEM_CAPTION);

           // String name = (String) clickedItem.get("name");

//            ArrayList<dumpclass> ob2j;
//            for (dumpclass cn : obj)
//            {4r
//               String a= cn.getname();
//            }



        //Toast.makeText(getApplicationContext(),"play", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file://" + filepath), "image/*");
            startActivity(intent);

    }
        @Override
        public void LoadDataForScroll(int count)
        {


        }

        @Override
        public void onDismiss(ListView listView, int[] reverseSortedPositions) {

            Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_SHORT).show();
            for(int i:reverseSortedPositions){
                listdata.remove(i);
                listAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void OnClickListView(int position) {

            Toast.makeText(getApplicationContext(),""+position, Toast.LENGTH_SHORT).show();
        }

    };
}
