package io.skipday.keepalive.utils;

import java.nio.charset.Charset;

/**
 * Created by jagamypriera on 03/04/16.
 */
public class StringCollection {

    /**
     * API key for https://import.io
     */
    public static final String IMPORT_IO_API_KEY="d0d036370a1e4874ac440f00c5ef6729407f538513441adf0427276fbf2de7e18af95085b6a94251101762b4b75eaaea965a1889720f41bce3646ee1602882193223c99fa7afa39702d357f0a028def5";
    public static final String EXTRA_QUERY="webpage/url:";

    /**
     * Target link to be extracted by import.io
     */
    public static final String MANGA_ONLINE_BASE_URL="http://mymangaonline.us/";
    public static final String MANGA_ONLINE_POPULAR_LIST=EXTRA_QUERY+MANGA_ONLINE_BASE_URL+"popular-manga.html?page=";
}
