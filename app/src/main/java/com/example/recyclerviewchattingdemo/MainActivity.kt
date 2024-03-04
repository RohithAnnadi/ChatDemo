package com.example.recyclerviewchattingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewchattingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chats: ArrayList<Chat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        setUpRecyclerView()
        addMoreChats()
    }
    private fun addMoreChats(){
        binding.btnUser1.setOnClickListener {
            val message = binding.inputMessage.text.toString()
            chats.add(Chat(1,message))
            chatAdapter.notifyItemInserted(chats.size)
            binding.inputMessage.text?.clear()
        }
        binding .btnUser2.setOnClickListener {
            val message = binding.inputMessage.text.toString()
            chats.add(Chat(2,message))
            chatAdapter.notifyItemInserted(chats.size)
            binding.inputMessage.text?.clear()
        }

    }

    private fun initData(){
        chats = ArrayList()
        chats.add(Chat(1,"Hey"))
        chats.add(Chat(2,"Hi"))
        chats.add(Chat(1,"How are you?"))
        chats.add(Chat(2,"I am good"))
        chatAdapter=ChatAdapter(chats)
    }

    private fun setUpRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = chatAdapter
    }

}