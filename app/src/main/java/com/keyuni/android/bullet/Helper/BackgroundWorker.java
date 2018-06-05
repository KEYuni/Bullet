package com.keyuni.android.bullet.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;

    public BackgroundWorker(Context ctx){

        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        String type = voids[0];
        String user_url = "http://bullet-finance.atwebpages.com/index.php/user";
        String usaha_url = "http://bullet-finance.atwebpages.com/index.php/usaha";
        String thread_url = "http://bullet-finance.atwebpages.com.index.php/thread";
        String komentar_url = "http://bullet-finance.atwebpages.com/index.php/komentar";
        String produk_url = "http://bullet-finance.atwebpages.com/index.php/produk";
        String pembeli_url = "http://bullet-finance.atwebpages.com/index.php/pembeli";
        String peminjaman_url = "http://bullet-finance.atwebpages.com/index.php/peminjaman";
        String keuangan_url = "http://bullet-finance.atwebpages.com/index.php/keuangan";

        if (type.equals("login")){
            try {
                String user_email = voids[1];
                String user_pass = voids[2];
                String user_aksi = "login";
                URL url = new URL(user_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("EMAIL", "UTF-8")+"="+URLEncoder.encode(user_email, "UTF-8")+"&"
                        +URLEncoder.encode("KATA_SANDI", "UTF-8")+"="+URLEncoder.encode(user_pass, "UTF-8")+"&"
                        +URLEncoder.encode("user_aksi", "UTF-8")+"="+URLEncoder.encode(user_aksi, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type.equals("register")){
            try {
                String nama = voids[1];
                String email = voids[2];
                String nohp = voids[3];
                String alamat = voids[4];
                String password = voids[5];
                String konf_pass = voids[6];
                String user_aksi = "register";

                URL url = new URL(user_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("NAMA", "UTF-8")+"="+URLEncoder.encode(nama, "UTF-8")+"&"
                        +URLEncoder.encode("EMAIL", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("NO_HP", "UTF-8")+"="+URLEncoder.encode(nohp, "UTF-8")+"&"
                        +URLEncoder.encode("ALAMAT", "UTF-8")+"="+URLEncoder.encode(alamat, "UTF-8")+"&"
                        +URLEncoder.encode("KATA_SANDI", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8")+"&"
                        +URLEncoder.encode("KONF_KATA_SANDI", "UTF-8")+"="+URLEncoder.encode(konf_pass, "UTF-8")+"&"
                        +URLEncoder.encode("user_aksi", "UTF-8")+"="+URLEncoder.encode(user_aksi, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                StringBuilder sb = new StringBuilder();

                while ( (line = bufferedReader.readLine()) != null){
                    sb.append(line + "\n");
                }

                result = sb.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }/*else if (type.equals("administrasi")){
            try {
                int id = Integer.parseInt(voids[1]);
                int nik = Integer.parseInt(voids[2]);
                String nama = voids[3];
                String tempat_lahir = voids[4];
                String tanggal_lahir = voids[5];
                String alamat = voids[6];
                String jenis = voids[7];

                String user_aksi = "administrasi";

                URL url = new URL(user_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(String.valueOf(id), "UTF-8")+"&"+
                        URLEncoder.encode("nik", "UTF-8")+"="+URLEncoder.encode(String.valueOf(nik), "UTF-8")+"&"+
                        URLEncoder.encode("nama", "UTF-8")+"="+URLEncoder.encode(nama, "UTF-8")+"&"+
                        URLEncoder.encode("tempat_lahir", "UTF-8")+"="+URLEncoder.encode(tempat_lahir, "UTF-8")+"&"+
                        URLEncoder.encode("tanggal_lahir", "UTF-8")+"="+URLEncoder.encode(tanggal_lahir, "UTF-8")+"&"+
                        URLEncoder.encode("alamat", "UTF-8")+"="+URLEncoder.encode(alamat, "UTF-8")+"&"+
                        URLEncoder.encode("jenis", "UTF-8")+"="+URLEncoder.encode(jenis, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                StringBuilder sb = new StringBuilder();

                while ( (line = bufferedReader.readLine()) != null){
                    sb.append(line + "\n");
                }

                result = sb.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        return null;
    }
    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
