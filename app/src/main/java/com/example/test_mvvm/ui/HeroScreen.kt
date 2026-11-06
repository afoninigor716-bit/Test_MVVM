package com.example.test_mvvm.ui

import android.media.midi.MidiDevice
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_mvvm.viewmodel.HeroVM
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun CountScreen(viewModel: HeroVM = viewModel()){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC19A6B))
            .safeDrawingPadding()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .safeDrawingPadding()

        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF3B2F2F))
                    .padding(15.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .safeDrawingPadding()
                ) {
                    Text("Историческая галерея",
                        fontSize =  24.sp,
                        color = Color(0xFFD4AF37))
                    //Spacer(modifier = Modifier.height(10.dp))
                    Text("Ключевые личности Северной войны",
                        fontSize =  16.sp,
                        color = Color(0xFFD4AF37))
                }


            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .padding(15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1E9D2))



            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = viewModel.currentHero.image),
                        contentDescription = null,
                        modifier = Modifier.size(220.dp).padding(top = 15.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "${viewModel.currentHero.name}\n${viewModel.currentHero.years_rule}",
                        modifier = Modifier.padding(end = 15.dp)


                    )


                }

                Spacer(modifier = Modifier.height(10.dp))

                Text("${viewModel.currentHero.description}",
                    modifier = Modifier.padding(horizontal = 15.dp).padding(bottom = 15.dp))




            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .verticalScroll(rememberScrollState())
            ) {
                for(hero in viewModel.heroes){

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3B2F2F),
                            contentColor = Color(0xFFD4AF37)
                        ) ,
                        onClick = {viewModel.selectHero(hero)}
                    ) {
                        Text(hero.name)
                    }
                }
            }



        }
    }





}