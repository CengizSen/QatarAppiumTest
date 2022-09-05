Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs


StartTest
-----------




*"com.m.qr:id/nav_menu_book" İd'li elementi bul ve tıkla
*"5" saniye bekle
*"com.m.qr:id/radio_onway" İd'li elementi bul ve tıkla
*"5" saniye bekle
*"com.m.qr:id/select_depart_station" İd'li elementi bul ve tıkla
*"5" saniye bekle

*"com.m.qr:id/search_edit_text" İd'li elementi bul ve "Berlin" değerini yaz
*"5" saniye bekle

*"//*[@resource-id='com.m.qr:id/station_search_text1']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"5" saniye bekle

*"com.m.qr:id/select_arrival_station" İd'li elementi bul ve tıkla
*"5" saniye bekle

*"com.m.qr:id/search_edit_text" İd'li elementi bul ve "Istanbul" değerini yaz
*"5" saniye bekle

*"//*[@resource-id='com.m.qr:id/station_search_text1']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"5" saniye bekle

*"com.m.qr:id/button_search" İd'li elementi bul ve tıkla
*"5" saniye bekle
*"com.m.qr:id/qr_tool_bar_title" İd'li element "Select outbound flight" değerini içeriyor mu kontrol et
*"8" saniye bekle
*"//*[@resource-id='com.m.qr:id/main_bg']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"7" saniye bekle
*"//android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]" Xpath'li elementi bul ve tıkla
* "3" saniye bekle







