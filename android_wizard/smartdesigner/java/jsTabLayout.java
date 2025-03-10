package org.lamw.appcompatlamwproject1;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.util.TypedValue;
import android.graphics.Typeface;

//-------------------------------------------------------------------------
// jsTabLayout
// Review by ADiV for LAMW on 2021-05-05
//-------------------------------------------------------------------------
 
/*
 *
 */
public class jsTabLayout extends TabLayout /*dummy*/ { //please, fix what GUI object will be extended!

   private long pascalObj = 0;        // Pascal Object
   private Controls controls  = null; //Java/Pascal [events] Interface ...
   private jCommons LAMWCommon;
   private Context context = null;
   
  // private OnClickListener onClickListener;   // click event
   private Boolean enabled  = true;           // click-touch enabled!
   
   //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ...
   public jsTabLayout(Controls _ctrls, long _Self) { //Add more others news "_xxx" params if needed!

      super(_ctrls.activity);
      context   = _ctrls.activity;
      pascalObj = _Self;
      controls  = _ctrls;      

      LAMWCommon = new jCommons(this,context,pascalObj);      

      /*
      onClickListener = new OnClickListener(){
      public void onClick(View view){     // *.* is a mask to future parse...;
              if (enabled) {
               //  controls.OnClickGeneric(pascalObj); //JNI event onClick!
              }
           };
      };      
      setOnClickListener(onClickListener);
      */
      //http://abhiandroid.com/materialdesign/tablayout-example-android-studio.html
      this.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {      
    	    @Override
    	    public void onTabSelected(TabLayout.Tab tab) {
    	    	    	    	    	    	
    	        // while selecting the tab ::  tab.getPosition()
    	    	//if(tab != null)
    	    		//controls.pOnSTabSelected(pascalObj, 0, "test");		
    	    	 controls.pOnSTabSelected(pascalObj, tab.getPosition(), tab.getText().toString());
    	    	 
    	    }
    	 
    	    @Override
    	    public void onTabUnselected(TabLayout.Tab tab) {
    	        // while unselect the Tab
    	    	
    	    }
    	 
    	    @Override
    	    public void onTabReselected(TabLayout.Tab tab) {
    	        // while reselect the Tab    	 
    	    }
    	});
            
        //this.setElevation(20);
   } //end constructor

     
   public void jFree() {
      //free local objects...
  	 //setOnClickListener(null);
	 LAMWCommon.free();
   }
 
   public void SetViewParent(ViewGroup _viewgroup) {
	 LAMWCommon.setParent(_viewgroup);
   }

   public ViewGroup GetParent() {
      return LAMWCommon.getParent();
   }

   public void RemoveFromViewParent() {
  	 LAMWCommon.removeFromViewParent();
   }

   public View GetView() {
      return this;
   }

   public void SetLParamWidth(int _w) {
  	 LAMWCommon.setLParamWidth(_w);
   }

   public void SetLParamHeight(int _h) {
  	 LAMWCommon.setLParamHeight(_h);
   }

   public int GetLParamWidth() {
      return LAMWCommon.getLParamWidth();
   }

   public int GetLParamHeight() {
	 return  LAMWCommon.getLParamHeight();
   }

   public void SetLGravity(int _g) {
  	 LAMWCommon.setLGravity(_g);
   }

   public void SetLWeight(float _w) {
  	 LAMWCommon.setLWeight(_w);
   }

   public void SetLeftTopRightBottomWidthHeight(int _left, int _top, int _right, int _bottom, int _w, int _h) {
      LAMWCommon.setLeftTopRightBottomWidthHeight(_left,_top,_right,_bottom,_w,_h);
   }

   public void AddLParamsAnchorRule(int _rule) {
	 LAMWCommon.addLParamsAnchorRule(_rule);
   }

   public void AddLParamsParentRule(int _rule) {
	 LAMWCommon.addLParamsParentRule(_rule);
   }

   public void SetLayoutAll(int _idAnchor) {
  	 LAMWCommon.setLayoutAll(_idAnchor);
   }

   public void ClearLayoutAll() {
	 LAMWCommon.clearLayoutAll();
   }

   //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ...
      
   public int AddTab(String _title) {
	  Tab t =  this.newTab();
	  
	  if(t == null) return -1;
	  
	  t.setText(_title);
	  
      this.addTab(t);
      
      return  t.getPosition();	  
   }
   
   public void SetupWithViewPager(View _viewpage) {	   
	   this.setupWithViewPager((ViewPager)_viewpage);
	   /*
	   final jsTabLayout ref = this;
	   final ViewPager vPage = (ViewPager)_viewpage;
	   this.post(new Runnable() {
		    @Override
		    public void run() {
		    	ref.setupWithViewPager(vPage);
		    }
		});
       */ 
   }
         
  public void SetFitsSystemWindows(boolean _value) {
	LAMWCommon.setFitsSystemWindows(_value);
  }

  public int GetTabCount() {	  
	  return this.getTabCount();	  	 
  }
   
  public void SetTabTextColors(int _normalColor, int _selectedColor) {
      this.setTabTextColors(_normalColor, _selectedColor);      
  }
    
  public void SetIcon(int _position, String _iconIdentifier) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return;
	  
	  Tab t =this.getTabAt(_position);
	  
	  if(t == null) return;	  
	  
	  int resId = context.getResources().getIdentifier(_iconIdentifier, "drawable", context.getPackageName() );    		
	  t.setIcon(resId);
  }	  
  
  public void SetPosition(int _position) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return;
	  
	  Tab t =this.getTabAt(_position);
	  
	  if(t == null) return;
	  
	  t.select();	  	 
  }	  
  
  public int GetPosition() {
	  return this.getSelectedTabPosition();
  }
	
  public boolean IsSelected(int _position) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return false;
	  
	  Tab t =this.getTabAt(_position);
	  
	  if(t == null) return false;
	  
      return t.isSelected();
  }	  
  
  public void SetCustomView(int _position, View _view) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return;
	  
	  Tab t =this.getTabAt(_position);
	  
	  if(t == null) return;
	   
	  t.setCustomView(_view);	
  }	   
  
  public void SetText(int _position,  String _title) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return;
	  
	  Tab t =this.getTabAt(_position);
	  
	  if(t == null) return;
	  
	  t.setText(_title);
  }

  public String GetText(int _position) {
	  if( (_position < 0) || (_position >=this.getTabCount()) ) return "";
	  
	  Tab t = this.getTabAt(_position);
	  
	  if(t == null) return "";
	  
	  return t.getText().toString();
	  
      /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) this.getChildAt(0)).getChildAt(_position);
	  
	  if(tabLayout == null) return t.getText().toString(); 
		  
      TextView tabTextView = (TextView) tabLayout.getChildAt(1);
      
      if(tabTextView == null) return t.getText().toString();       
	  
	  return tabTextView.getText().toString();*/
  }

  public String GetTitle(int _position) {
      return GetText(_position);
  }

  public void SetTabMode(int _tabmode) { 
	  
	  switch( _tabmode ) {
	  case 0: this.setTabMode(TabLayout.MODE_FIXED); break;
	  case 1: this.setTabMode(TabLayout.MODE_SCROLLABLE); break;
	  }	  
  }
  
  public Tab GetTabAt(int _position) {	
	 if( (_position < 0) || (_position >=this.getTabCount()) ) return null;
	  
	 Tab t =this.getTabAt(_position);
	 
	 if(t == null) return null;
	 
	 return t;
  }

  public int GetSelectedTabPosition() {
       return this.getSelectedTabPosition();
  }
  
  //https://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
  //http://en.proft.me/2016/06/21/how-organize-content-tabs-tablayout-and-viewpager-/
  //http://blog.iamsuleiman.com/material-design-tabs-with-android-design-support-library/ complete demo 2
  
  public void SetSelectedTabIndicatorColor(int _color) {
     this.setSelectedTabIndicatorColor(_color);  //Color.parseColor("#FFFFFF")    
  }
  
  public void SetSelectedTabIndicatorHeight(int _height) {
	 int h =  (int) (_height * getResources().getDisplayMetrics().density);  //_height = 2
     this.setSelectedTabIndicatorHeight(h);
  }
  
  public void SetTabGravity(int _tabGravity) {	  
	  switch( _tabGravity ) {
	  case 0:  this.setTabGravity(TabLayout.GRAVITY_FILL); break;
	  case 1:  this.setTabGravity(TabLayout.GRAVITY_CENTER); break;
	  }	       
  }
  
  public void SetElevation(int _value) {
      this.setElevation(_value);
  }
    
  public void SetBackgroundToPrimaryColor() {	   
	   this.setBackgroundColor(LAMWCommon.getColorFromResources(context, R.color.primary)); 
  }
  
  public void RemoveAllTabs(){
	  this.removeAllTabs();
  }
  
  public void RemoveTabAt(int _position) {	
		 if( (_position < 0) || (_position >=this.getTabCount()) ) return;
		  
		 this.removeTabAt(_position);
  }
  
}
 
