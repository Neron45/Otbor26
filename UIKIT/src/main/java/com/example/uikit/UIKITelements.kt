package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.uikit.TxtFieldImg
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

var sfproreg = FontFamily(Font(com.example.uikit.R.font.sfproreg))
var sfprosemibold = FontFamily(Font(com.example.uikit.R.font.sfprosemibold))
var summaAll = mutableStateOf(0)
var sfprobold = FontFamily(Font(com.example.uikit.R.font.sfprobold))

var robotomed = FontFamily(Font(com.example.uikit.R.font.robotomed))
var robotobold = FontFamily(Font(com.example.uikit.R.font.robotobold))
var card1vis = mutableStateOf(false)
var card2vis = mutableStateOf(false)

var click by mutableStateOf<String?>("")
var counter by mutableStateOf<Int>(0)
@Composable
fun UIKITbtn(item: Btn){
    Button(onClick = {click = item.id
        if (counter < 4) counter++},

        modifier = Modifier
            .height(item.height_btn.dp)
            .width(item.width_btn.dp)
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (click == item.id) Color(0xFF1A6FEE) else Color(0xFFF5F5F9),
            contentColor = if (click == item.id) Color(0xFFFFFFFF) else Color(0xFF000000),
        )

    ) {
        Text(
            text = item.id,
            fontSize = 24.sp,
            fontFamily = sfprobold
        )
    }
}

@Composable
fun UIKITbtn_main(item: Btn_main, onClick: () -> Unit){
    Button(
        onClick = onClick,

        modifier = Modifier
            .padding(top = item.padingtop.dp, start = item.padingstart.dp)
            .height(item.height_btn.dp)
            .width(item.width_btn.dp)
            .background(Color(item.color), RoundedCornerShape(item.shape.dp)),
        enabled = item.enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(item.color),
            contentColor = Color(item.colortext),
        )

    ) {
        Text(
            text = item.label,
            fontSize = item.textsize.sp,
            fontFamily = item.font
        )

    }

}

@Composable
fun UIKIToutltextfield(item: TxtField){
    val text = remember {  mutableStateOf("") }
    OutlinedTextField(
        value = item.text.value,
        {newText -> item.text.value = newText},
        modifier = Modifier
            .width(item.width.dp)
            .height(item.heigth.dp)
            .background(Color(item.color), RoundedCornerShape(item.shape.dp)),
        shape = RoundedCornerShape(item.shape.dp),
        textStyle = TextStyle(
            fontSize = item.fontsize.sp,
            fontFamily = item.font,
            color = Color(item.fontcolor)

        ),
        placeholder = {
            Text(
                text = item.text_pl,
                style = TextStyle(
                    fontFamily = item.font_pl,
                    fontSize = item.fontsize_pl.sp,
                    color = Color(item.fontcolor_pl)
                ),

                )

        }
    )


}

@Composable
fun UIKIToutltextfieldImg(item: TxtFieldImg){
    var clicked = remember { mutableStateOf<Boolean?>(true) }
    OutlinedTextField(
        value = item.text.value,
        {newText -> item.text.value = newText},
        modifier = Modifier
            .width(item.width.dp)
            .height(item.heigth.dp)
            .background(Color(item.color), RoundedCornerShape(item.shape.dp)),
        shape = RoundedCornerShape(item.shape.dp),
        textStyle = TextStyle(
            fontSize = item.fontsize.sp,
            fontFamily = item.font,
            color = Color(item.fontcolor)

        ),

        visualTransformation = if (clicked.value == false) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Image(
                painter = painterResource(if (clicked.value == true) item.icon else item.iconCl),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .clickable{
                        if (clicked.value == true) clicked.value = false else clicked.value = true
                    }
            )

        },

        placeholder = {
            Text(
                text = item.text_pl,
                style = TextStyle(
                    fontFamily = item.font_pl,
                    fontSize = item.fontsize_pl.sp,
                    color = Color(item.fontcolor_pl)
                ),

                )

        }
    )
}

@Composable
fun UIKITstatusbar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.23f),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "9:41",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 22.sp,
                modifier = Modifier
                    .background(Color.White)
            )

        }
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.72f)
            .background(Color.Black, RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp))) {

        }
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.wifi),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .fillMaxHeight(0.7f)
            )

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIKITcard(item: Cards, BtnClick: () -> Unit){
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(top = item.paddingTop.dp, start = item.paddingStart.dp)
        .size(item.sizeW.dp, item.sizeH.dp)
        .background(Color(item.Color), RoundedCornerShape(item.Shape.dp))
        .clickable{
            showBottomSheet = true
        }
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Text(
                            text = item.text1,
                            color = Color.Black,
                            fontFamily = sfprobold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 20.dp, top = 20.dp)
                                .fillMaxWidth(0.7f)
                        )

//                    Button(
//                        onClick = {
//                        scope.launch { sheetState.hide() }.invokeOnCompletion {
//                            if (!sheetState.isVisible) {
//                                showBottomSheet = false
//                            }
//                        }
//                    },
//                        modifier = Modifier
//                            .background(Color(0xFFB8C1CC), CircleShape),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xFFB8C1CC),
//                        ),
//
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.krest),
//                            contentDescription = "",
//                            modifier = Modifier
//                                .padding(3.dp)
//                                .size(10.dp, 20.dp)
//                                .background(Color.Red)
//
//                        )
//                    }

                        Image(
                            painter = painterResource(R.drawable.krest),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 55.dp, top = 20.dp)
                                .size(25.dp)
                                .background(Color(0xFFB8C1CC), CircleShape)
                                .clickable{
                                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                                        if (!sheetState.isVisible) {
                                            showBottomSheet = false
                                        }
                                    }
                                },

                            )


                    }

                    Text(
                        text = "Описание",
                        color = Color(0xFF939396),
                        fontFamily = sfprobold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp)
                    )

                    Text(
                        text = "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
                                "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n" +
                                "Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г.\n" +
                                "Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие.\n" +
                                "Примерный расход на шапку с подгибом 70-90г.",
                        color = Color.Black,
                        fontFamily = robotomed,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                    )

                    Text(
                        text = "Примерный расход:",
                        color = Color(0xFF939396),
                        fontFamily = sfprobold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 35.dp)
                    )

                    Text(
                        text = "80-90 г",
                        color = Color.Black,
                        fontFamily = sfprobold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 5.dp)
                    )

                    UIKITbtn_main(item = Btn_main (
                        width_btn = 365,
                        height_btn = 60,
                        label = "Добавить за ${item.price}",
                        color = 0xFF1A6FEE ,
                        colortext = 0xFFFFFFFF,
                        shape = 10,
                        textsize = 18,
                        font = robotobold,
                        padingtop = 15,
                        padingstart = 20,
                        enabled = true
                    )) {

                    }


                }




            }
        }


        Text(
            text = item.text1,
            color = Color(item.text1Color),
            fontFamily = item.text1Font,
            fontSize = item.text1Size.sp,
            modifier = Modifier
                .padding(top = item.text1PaddingTop.dp, start = item.text1PaddingStart.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = item.text2,
                    color = Color(item.text2Color),
                    fontFamily = item.text2Font,
                    fontSize = item.text2Size.sp,
                    modifier = Modifier
                        .padding(top = item.text2PaddingTop.dp, start = item.text1PaddingStart.dp)
                )
                Text(
                    text = item.price,
                    color = Color(item.priceColor),
                    fontFamily = item.priceFont,
                    fontSize = item.priceSize.sp,
                    modifier = Modifier
                        .padding(top = item.pricePaddingTop.dp, start = item.pricePaddingStart.dp)
                )
            }
            var clicked = remember { mutableStateOf<Boolean?>(true) }
            Button(
                onClick = {
                    if (clicked.value == true) clicked.value = false else clicked.value = true
                    BtnClick()
                },
                modifier = Modifier
                    .padding(top = item.btnPaddingTop.dp, start = item.btnPaddingStart.dp)
                    .size(item.btnSizeW.dp, item.btnSizeH.dp)
                    .border(item.btnborderW.dp, Color(item.btnborderColor), RoundedCornerShape(item.btnborderShape.dp))
                    .background( Color(item.btnColor), RoundedCornerShape(item.btnshape.dp)),
                shape = RoundedCornerShape(item.btnshape.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(item.btnColor),
                    contentColor = Color(item.btntextColor),
                )

            ) {
                Text(
                    text = item.btntext
                )
            }
        }
    }
}




@Composable
fun UIKITcardKr(item: CardKR){
    var card_ = remember {  mutableStateOf(true) }
    var counter = remember { mutableStateOf(1) }
    var price = remember { mutableStateOf(item.price * counter.value) }

    if (card_.value){
        Column(modifier = Modifier
            .padding(top = item.paddingTop.dp, start = item.paddingStart.dp)
            .size(item.sizeW.dp, item.sizeH.dp)
            .background(Color.White, RoundedCornerShape(item.Shape.dp))
            .shadow(elevation = 1 .dp, RoundedCornerShape(3.dp), spotColor = Color(0xFFF4F4F4))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)

            ) {
                Text(
                    text = item.text1,
                    color = Color(item.text1Color),
                    fontFamily = item.text1Font,
                    fontSize = item.text1Size.sp,
                    modifier = Modifier
                        .padding(top = item.text1PaddingTop.dp, start = item.text1PaddingStart.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(0.8f)
                )
                Image(
                    painter = painterResource(R.drawable.krest),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 35.dp, top = 20.dp)
                        .size(20.dp)
                        .clickable{
                            card_.value = false
                            summaAll.value -= price.value
                            if (item.text1 == "Шорты вторник для машинного вязания") card2vis.value = false else card1vis.value = false

                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = "${price.value} ₽",
                    color = Color(item.priceColor),
                    fontFamily = item.priceFont,
                    fontSize = item.priceSize.sp,
                    modifier = Modifier
                        .padding(top = item.pricePaddingTop.dp, start = item.pricePaddingStart.dp)
                )

                Text(
                    text = if (counter.value == 1) "${counter.value} штука" else if (counter.value > 4) "${counter.value} штук  " else "${counter.value} штуки",
                    color = Color(item.text2Color),
                    fontFamily = item.text2Font,
                    fontSize = item.text2Size.sp,
                    modifier = Modifier
                        .padding(top = item.text2PaddingTop.dp, start = if (price.value > 999) (item.text2PaddingStart - 10).dp else if (price.value > 9999) (item.text2PaddingStart - 50).dp else item.text2PaddingStart.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(start = if (counter.value <= 9) 35.dp else 27.dp, top = 35.dp)
                        .size(70.dp, 35.dp)
                        .background(Color(0xFFF5F5F9), RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = painterResource(R.drawable.minus),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxHeight()
                            .fillMaxWidth(0.4f)
                            .clickable{
                                if (counter.value != 1) summaAll.value -= item.price
                                if (counter.value != 1) counter.value--
                                price.value = item.price * counter.value


                            }
                    )
                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .clickable{
                                summaAll.value += item.price
                                counter.value++
                                price.value = item.price * counter.value
                            }
                    )

                }
            }
        }
    }


}

var bb = mutableStateOf("Главная")
@Composable
fun UIKITbottombarelem(item: BBL, clickable: () -> Unit){


    Column(
        modifier = Modifier
            .padding(top = item.paddingTop.dp, start = item.paddingStart.dp)
            .size(item.sizeW.dp, item.sizeH.dp)
            .clickable{clickable()},
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(item.image),
            contentDescription = "",
            modifier = Modifier
                .padding(top = item.imagePaddingTop.dp, start = item.imagePaddingStart.dp)
                .size(item.imageSize.dp)
        )
        Text(
            text = item.text,
            color = Color(item.textColor),
            fontFamily = item.textFont,
            fontSize = item.textSize.sp,
            modifier = Modifier
                .padding(top = item.textPaddingTop.dp, start = item.textPaddingStart.dp)
        )
    }
}

@Composable
fun UIKITbotmBar(GoTo_main_katalog: () -> Unit, GoTo_main: () -> Unit, GoTo_main_proekt: () -> Unit, GoTo_main_profil: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .border(2.dp , Color(0x4DA0A0A0)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        UIKITbottombarelem(item = BBL(
            image = if (bb.value == "Главная") R.drawable.dom else R.drawable.dom_ser,
            paddingTop = 20,
            paddingStart = 0,
            sizeW = 90,
            sizeH = 60,
            imagePaddingTop = 5,
            imagePaddingStart = 0,
            imageSize = 35,
            text = "Главная",
            textFont = robotomed,
            textSize = 12,
            textColor = if (bb.value == "Главная") 0xFF1A6FEE else 0xFFB8C1CC,
            textPaddingTop = 0,
            textPaddingStart = 0
        )) {
            if (bb.value != "Главная") bb.value = "Главная"
            if (bb.value == "Главная") GoTo_main()
        }

        UIKITbottombarelem(item = BBL(
            image = if (bb.value == "Каталог") R.drawable.kotlg else R.drawable.kotlg_ser,
            paddingTop = 20,
            paddingStart = 0,
            sizeW = 90,
            sizeH = 60,
            imagePaddingTop = 5,
            imagePaddingStart = 0,
            imageSize = 35,
            text = "Каталог",
            textFont = robotomed,
            textSize = 12,
            textColor = if (bb.value == "Каталог") 0xFF1A6FEE else 0xFFB8C1CC,
            textPaddingTop = 0,
            textPaddingStart = 0
        )){if (bb.value != "Каталог") bb.value = "Каталог"
            if (bb.value == "Каталог") GoTo_main_katalog()
        }

        UIKITbottombarelem(item = BBL(
            image = if (bb.value == "Проекты") R.drawable.proekt else R.drawable.proekt_ser,
            paddingTop = 20,
            paddingStart = 0,
            sizeW = 90,
            sizeH = 60,
            imagePaddingTop = 5,
            imagePaddingStart = 0,
            imageSize = 35,
            text = "Проекты",
            textFont = robotomed,
            textSize = 12,
            textColor = if (bb.value == "Проекты") 0xFF1A6FEE else 0xFFB8C1CC,
            textPaddingTop = 0,
            textPaddingStart = 0
        )){if (bb.value != "Проекты") bb.value = "Проекты"
            if (bb.value == "Проекты") GoTo_main_proekt()}

        UIKITbottombarelem(item = BBL(
            image = if (bb.value == "Профиль") R.drawable.profil else R.drawable.profil_ser,
            paddingTop = 20,
            paddingStart = 0,
            sizeW = 90,
            sizeH = 60,
            imagePaddingTop = 5,
            imagePaddingStart = 0,
            imageSize = 35,
            text = "Профиль",
            textFont = robotomed,
            textSize = 12,
            textColor = if (bb.value == "Профиль") 0xFF1A6FEE else 0xFFB8C1CC,
            textPaddingTop = 0,
            textPaddingStart = 0
        )){if (bb.value != "Профиль") bb.value = "Профиль"
            if (bb.value == "Профиль") GoTo_main_profil()}

    }
}

@Composable
fun UIKITinputs_proekt(){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .height(950.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Тип",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfieldImg(item = TxtFieldImg(
                text = remember { mutableStateOf("") } ,
                350,
                55,
                0xFFF5F5F9,
                10,
                sfproreg,
                16,
                0xFF000000,
                "Выберите тип",
                sfproreg, 16,
                0xFF000000,
                icon = R.drawable.strl_vnis,
                iconCl = R.drawable.strl_vverh

            )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Название проекта",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    350,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Введите имя",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Дата начала",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    350,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "--.--.----",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Дата Окончания",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    350,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "--.--.----",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Кому",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfieldImg(item = TxtFieldImg(
                text = remember { mutableStateOf("") } ,
                350,
                55,
                0xFFF5F5F9,
                10,
                sfproreg,
                16,
                0xFF000000,
                "Выберите кому",
                sfproreg, 16,
                0xFF000000,
                icon = R.drawable.strl_vnis,
                iconCl = R.drawable.strl_vverh

            )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Источник описания",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    350,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "example.com",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                )
            )

        }

        Column(
            modifier = Modifier
                .size(350.dp, 65.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Категория",
                color = Color(0xFF7E7E9A),
                fontFamily = sfproreg,
                fontSize = 14.sp
            )

            UIKIToutltextfieldImg(item = TxtFieldImg(
                text = remember { mutableStateOf("") } ,
                350,
                55,
                0xFFF5F5F9,
                10,
                sfproreg,
                16,
                0xFF000000,
                "Выберите категорию",
                sfproreg, 16,
                0xFF000000,
                icon =  R.drawable.strl_vnis,
                iconCl = R.drawable.strl_vverh

            )
            )

        }

        Column(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .size(180.dp)
                .background(Color(0xFFF7F7FA), RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bigplus),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(0.5f)
            )
        }

    }
}

@Composable
fun UIKITcheckBx(){
    var check = remember {mutableStateOf(true)}
    Row(
        modifier = Modifier
            .padding(start = 80.dp, top = 20.dp)
            .size(65.dp, 35.dp)
            .background(if (check.value == true) Color(0xFF1A6FEE) else Color(0xFF939396), CircleShape)
            .clickable{
                if (check.value == true) check.value = false else check.value = true
            },

        ) {
        Row(
            modifier = Modifier
                .padding( top = 4.dp , bottom = 4.dp, start = if (check.value == true) 35.dp else 4.dp)
                .size(27.dp)
                .background(Color.White, CircleShape)
        ) {  }
    }
}