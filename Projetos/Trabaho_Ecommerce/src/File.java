import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class File {

    public <T> void WriteArrayJson(String path, List<T> objetos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(objetos);
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WriteJson(String path, Object objeto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(objeto);
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddObjectJson(String path, Object objeto) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            String json = reader.readLine();
            List<Object> objetos = this.ReadArrayJson(path, Object.class);
            objetos.add(objeto);
            WriteArrayJson(path, objetos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RemoveObjectJson(String path, Object objeto) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            String json = reader.readLine();
            List<Object> objetos = this.ReadArrayJson(path, Object.class);
            objetos.remove(objeto);
            WriteArrayJson(path, objetos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> ReadArrayJson(String path, Class<T> clazz) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public <T> T ReadJson(String path, Class<T> clazz) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
