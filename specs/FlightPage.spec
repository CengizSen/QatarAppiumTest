Specification Heading
=====================
Created by testinium on 5.09.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Flight Page
----------------
*"com.m.qr:id/search_edit_text" İd'li elementi bul ve "Berlin" değerini yaz
*"10" saniye bekle

*"//*[@resource-id='com.m.qr:id/station_search_text1']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"10" saniye bekle

*"com.m.qr:id/select_arrival_station" İd'li elementi bul ve tıkla
*"10" saniye bekle

*"com.m.qr:id/search_edit_text" İd'li elementi bul ve "Istanbul" değerini yaz
*"10" saniye bekle

*"//*[@resource-id='com.m.qr:id/station_search_text1']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"10" saniye bekle

*"com.m.qr:id/button_search" İd'li elementi bul ve tıkla
*"10" saniye bekle
*"com.m.qr:id/qr_tool_bar_title" İd'li element "Select outbound flight" değerini içeriyor mu kontrol et
*"10" saniye bekle
*"//*[@resource-id='com.m.qr:id/main_bg']" Xpath'li elementler arasında rasgele bir tanesine tıkla
*"10" saniye bekle