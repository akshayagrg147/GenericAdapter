package com.gpson.viewmodal

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.gpson.GeneriAdapter.GenericAdapter
import com.gpson.R
import com.gpson.modal.jsonModalClass

class MainVM:ViewModel() {

    val adapter by lazy { GenericAdapter<jsonModalClass.Pet>(R.layout.item_recycler) }

    init {
        convertJsontoObJect{
            adapter.addItems(
                it.pets as List<jsonModalClass.Pet>
              )
        }

       adapter.setOnListItemViewClickListener(object : GenericAdapter.OnListItemViewClickListener {
           override fun onClick(view: View, position: Int) {
               when(view.id){
                   R.id.clTop -> {
                       Toast.makeText(view.context,adapter.items[position].contentUrl,Toast.LENGTH_SHORT).show()
                   }
               }
           }
       })
    }

    private fun convertJsontoObJect(calllist:(jsonModalClass)->Unit) {
         val json="{\n" +
                "  \"pets\": [\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Cat_poster_1.jpg/1200px-Cat_poster_1.jpg\",\n" +
                "      \"title\": \"Cat\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Cat\",\n" +
                "      \"date_added\": \"2018-06-02T03:27:38.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/3/30/RabbitMilwaukee.jpg\",\n" +
                "      \"title\": \"Rabbit\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Rabbit\",\n" +
                "      \"date_added\": \"2018-06-06T08:36:16.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/3/32/Ferret_2008.png\",\n" +
                "      \"title\": \"Ferret\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Ferret\",\n" +
                "      \"date_added\": \"2018-06-23T19:14:04.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/e/e9/Goldfish3.jpg\",\n" +
                "      \"title\": \"Goldfish\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Goldfish\",\n" +
                "      \"date_added\": \"2018-07-12T15:49:27.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Collage_of_Nine_Dogs.jpg/1200px-Collage_of_Nine_Dogs.jpg\",\n" +
                "      \"title\": \"Dog\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Dog\",\n" +
                "      \"date_added\": \"2018-07-21T11:33:29.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/6/6d/Blue-and-Yellow-Macaw.jpg\",\n" +
                "      \"title\": \"Parrot\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Parrot\",\n" +
                "      \"date_added\": \"2018-07-26T04:20:16.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/9/9f/Raccoon_climbing_in_tree_-_Cropped_and_color_corrected.jpg\",\n" +
                "      \"title\": \"Raccoon\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Raccoon\",\n" +
                "      \"date_added\": \"2018-07-29T20:58:39.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/d/d4/Igel01.jpg\",\n" +
                "      \"title\": \"Hedgehog\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Hedgehog\",\n" +
                "      \"date_added\": \"2018-07-30T18:10:57.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/d/de/Nokota_Horses_cropped.jpg\",\n" +
                "      \"title\": \"Horse\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Horse\",\n" +
                "      \"date_added\": \"2018-08-02T05:04:03.027Z\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"image_url\": \"https://upload.wikimedia.org/wikipedia/commons/0/00/Two_adult_Guinea_Pigs_%28Cavia_porcellus%29.jpg\",\n" +
                "      \"title\": \"Guinea Pig\",\n" +
                "      \"content_url\": \"https://en.wikipedia.org/wiki/Guinea_pig\",\n" +
                "      \"date_added\": \"2018-08-04T10:45:29.027Z\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"

        val objectvalue = Gson().fromJson(json, jsonModalClass::class.java)
        calllist(objectvalue)
    }
}