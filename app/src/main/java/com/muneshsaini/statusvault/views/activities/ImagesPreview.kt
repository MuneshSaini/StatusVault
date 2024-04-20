package com.muneshsaini.statusvault.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muneshsaini.statusvault.databinding.ActivityImagesPreviewBinding
import com.muneshsaini.statusvault.models.MediaModel
import com.muneshsaini.statusvault.utils.Constants
import com.muneshsaini.statusvault.views.adapters.ImagePreviewAdapter

class ImagesPreview : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityImagesPreviewBinding.inflate(layoutInflater)
    }
    lateinit var adapter: ImagePreviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val list =
                intent.getSerializableExtra(Constants.MEDIA_LIST_KEY) as ArrayList<MediaModel>
            val scrollTo = intent.getIntExtra(Constants.MEDIA_SCROLL_KEY, 0)
            adapter = ImagePreviewAdapter(list, activity)
            imagesViewPager.adapter = adapter
            imagesViewPager.currentItem = scrollTo
        }

    }
}