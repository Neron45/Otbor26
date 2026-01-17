package com.example.otbor26

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.fromColorLong
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.otbor26.ui.theme.botmBar
import com.example.otbor26.ui.theme.btn
import com.example.uikit.UIKITbtn
import com.example.uikit.UIKITcard
import com.example.uikit.UIKITbottombarelem
import com.example.uikit.UIKIToutltextfield
import com.example.uikit.UIKITbotmBar
import com.example.uikit.UIKITbtn_main
import com.example.uikit.UIKITcardKr
import com.example.uikit.UIKITcheckBx
import com.example.uikit.UIKITinputs_proekt
import com.example.uikit.UIKIToutltextfieldImg
import com.example.uikit.Btn
import com.example.uikit.TxtFieldImg
import com.example.uikit.Btn_main
import com.example.uikit.Cards
import com.example.uikit.CardKR
import com.example.uikit.BBL
import com.example.uikit.TxtField

import com.example.uikit.click
import com.example.uikit.counter
import com.example.uikit.card1vis
import com.example.uikit.card2vis
import com.example.otbor26.ui.theme.btn_main
import com.example.otbor26.ui.theme.card
import com.example.otbor26.ui.theme.cardKr
import com.example.otbor26.ui.theme.checkBx
import com.example.otbor26.ui.theme.inputs_proekt
import com.example.otbor26.ui.theme.outltextfield
import com.example.otbor26.ui.theme.outltextfieldImg
import com.example.otbor26.ui.theme.statusbar
import com.example.otbor26.ui.theme.summaAll
import com.example.uikit.UIKITstatusbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
            MyApp(activity = this)

        }
    }
}

var sfproreg = FontFamily(Font(R.font.sfproreg))
var sfprosemibold = FontFamily(Font(R.font.sfprosemibold))

var sfprobold = FontFamily(Font(R.font.sfprobold))

var robotomed = FontFamily(Font(R.font.robotomed))
var robotobold = FontFamily(Font(R.font.robotobold))

val email = mutableStateOf("")
val parol = mutableStateOf("")

val p1 = mutableStateOf("")
val p2 = mutableStateOf("")

@Composable
fun MyApp(activity: MainActivity){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        composable("splash"){
            splash{
                navController.navigate("sign_in") {

                    popUpTo("splash") { inclusive = true }
                }
            }

        }
        composable("sign_in"){
            sign_in(
                GoTo_sign_in2 = {navController.navigate("sign_in2")}
            )
        }
        composable("sign_in2"){
            sign_in2(
                GoTo_sign_in3 = {navController.navigate("sign_in3")}
            )
        }
        composable("sign_in3"){
            sign_in3(
                GoToCreatepasword = {navController.navigate("createpasword")}
            )
        }
        composable("createpasword"){
            createpasword(
                GoToCreatepin = {navController.navigate("createpin")}
            )
        }

        composable("createpin"){
            createpin(
                GoTo_main = {navController.navigate("main")}
            )
        }
        composable("main"){
            main_(
                GoTo_main_katalog = {navController.navigate("main_katalog")},
                GoTo_main_proekt = {navController.navigate("main_proekt")},
                GoTo_main_profil = {navController.navigate("main_profil")},
                GoTo_korzina = {navController.navigate("korzina")}
            )
        }
        composable("main_katalog"){
            main_katalog(
                GoTo_main = {navController.navigate("main")},
                GoTo_main_proekt = {navController.navigate("main_proekt")},
                GoTo_main_profil = {navController.navigate("main_profil")},
                GoTo_korzina = {navController.navigate("korzina")}
            )
        }
        composable("main_proekt"){
            main_proekt(
                GoTo_main_katalog = {navController.navigate("main_katalog")},
                GoTo_main_profil = {navController.navigate("main_profil")},
                GoTo_main = {navController.navigate("main")},
                GoTo_create_proekt = {navController.navigate("create_proekt")}
            )
        }
        composable("main_profil"){
            main_profil(
                GoTo_main_katalog = {navController.navigate("main_katalog")},
                GoTo_main = {navController.navigate("main")},
                GoTo_main_proekt = {navController.navigate("main_proekt")},
            )
        }
        composable("create_proekt"){
            create_proekt(
                GoTo_main_katalog = {navController.navigate("main_katalog")},
                GoTo_main = {navController.navigate("main")},
                GoTo_main_profil = {navController.navigate("main_profil")}
            )
        }
        composable("korzina"){
            korzina(
                GoTo_main_katalog = {navController.navigate("main_katalog")},
            )
        }




    }
}



var click_ by mutableStateOf<String?>("Все")


@Composable
fun splash(onTimeout: () -> Unit){
    LaunchedEffect(Unit) {
        delay(3000L)
        onTimeout()
    }
    val linearGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFA1CAFF),
            Color(0xFF4D9CFF),
            Color(0xFF2254F5),
            Color(0xFF4D9CFF),
        ),

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(linearGradient),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Matule",
            color = Color.White,
            fontFamily = sfproreg,
            fontSize = 40.sp
        )

    }

}




@Composable
fun sign_in(GoTo_sign_in2: () -> Unit){



    LaunchedEffect(counter) {
        if (counter == 4){
            delay(2000)
            GoTo_sign_in2()
            counter = 0
        }
    }



    statusbar()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Вход",
            fontFamily = robotobold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 150.dp)
        )

        Row(modifier = Modifier
            .padding(top = 120.dp)
            .fillMaxHeight(0.035f)
            .fillMaxWidth(0.35f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = if (counter >= 1) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f)
            )
            Image(
                painter = if (counter >= 2) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.33f)
            )
            Image(
                painter = if (counter >= 3) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
            )
            Image(
                painter = if (counter == 4) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
        }

        Column(modifier = Modifier
            .padding(top = 50.dp)
            .size(260.dp, 380.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"1", "1"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"2", "2"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF, "3", "3"))
            }
            //2
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF, "4", "4"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF, "5", "5"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF,"6", "6"))

            }
            //3
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"7", "7"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,  0xFFFFFFFF,"8", "8"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"9", "9"))

            }
            //4
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                Spacer(modifier = Modifier
                    .size(80.dp))

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF, "0", "0"))

                Button(
                    onClick = {
                        click = "10"
                        if (counter != 0) counter--
                              },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (click == "10") Color(0xFF1A6FEE) else Color(0xFFF5F5F9),
                    )

                ) {
                    Image(
                        painter = painterResource(R.drawable.del),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                    )

                }
            }
        }
    }

}

@Composable
fun sign_in2(GoTo_sign_in3: () -> Unit){
    UIKITstatusbar()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.1f)
        ) {
            Image(
                painter = painterResource(R.drawable.hello),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.2f)
            )

            Text(
                text = "Добро пожаловать!",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 28.sp
            )

        }

        Text(
            text = "Войдите, чтобы пользоваться функциями приложения",
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = sfproreg,
            modifier = Modifier
                .padding(start = 40.dp)
        )

        Column(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(0.9f)
            .height(180.dp),
            verticalArrangement = Arrangement.SpaceBetween


        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)

            ) {

                Text(
                    text = "Вход по E-mail",
                    color = Color(0xFF7E7E9A),
                    fontFamily = sfproreg,
                    fontSize = 20.sp
                )

                val isError = remember { mutableStateOf(false) }
                var emailAddres = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = emailAddres.value,
                    onValueChange = { newText ->
                        emailAddres.value = newText
                        // Проверяем email при каждом изменении
                        isError.value = newText.isNotEmpty() && !isValidEmail(newText)
                    },
                    modifier = Modifier
                        .size(400.dp, 100.dp)
                        .background(Color(0xFFF5F5F9), RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(
                        color = Color(0xFF000000),
                        fontSize = 20.sp,
                        fontFamily = sfproreg
                    ),
                    placeholder = {
                        Text(
                            text = "example@mail.ru",
                            fontSize = 20.sp,
                            fontFamily = sfproreg,
                            color = Color(0xFFAEAEB2)
                        )
                    },
                    isError = isError.value,
                    supportingText = {
                        if (isError.value) {
                            Text(
                                text = "Не корректный email. Формат: example@mail.ru",
                                color = Color(0xFFFF4646),
                                fontFamily = sfproreg,
                                fontSize = 14.sp,
//                                modifier = Modifier
//                                    .padding(top = 10.dp, start = 20.dp)
                            )
                        }
                    }

                )



            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)

            ) {

                Text(
                    text = "Пароль",
                    color = Color(0xFF7E7E9A),
                    fontFamily = sfproreg,
                    fontSize = 20.sp
                )

                UIKIToutltextfieldImg(item = TxtFieldImg(
                    text = remember { mutableStateOf("") } ,
                    400,
                    80,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    20,
                    0xFF000000,
                    "",
                    sfproreg, 20,
                    0xFFAEAEB2,
                    icon = R.drawable.gl_otkr,
                    iconCl = R.drawable.gl_zakr

                )
                )

            }
        }

        UIKITbtn_main(item = Btn_main(
            width_btn = 375,
            height_btn = 70,
            color = 0xFF1A6FEE,
            colortext = 0xFFFFFFFF,
            label = "Далее",
            shape = 10,
            textsize = 18,
            font = sfprobold,
            padingtop = 30,
            padingstart = 0,
            enabled = true
        ), onClick = {GoTo_sign_in3()})

        Text(
            text = "Зарегистрироваться",
            color = Color(0xFF2074F2),
            fontFamily = robotomed,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Text(
            text = "Или войдите с помощью",
            color = Color(0xFF939396),
            fontFamily = sfproreg,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 60.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .border(1.dp,Color(0xFFEBEBEB), RoundedCornerShape(12.dp))
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.vk),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .size(40.dp)
            )
            Text(
                text = "Войти с VK",
                fontSize = 20.sp,
                fontFamily = robotomed,
                color = Color.Black
            )

        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .border(1.dp,Color(0xFFEBEBEB), RoundedCornerShape(12.dp))
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.yandex),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .size(40.dp)
            )
            Text(
                text = "Войти с Yandex",
                fontSize = 20.sp,
                fontFamily = robotomed,
                color = Color.Black
            )

        }
    }

}

fun isValidEmail(email: String): Boolean {
    // Паттерн для name@domenname.ru (только маленькие буквы и цифры)
    val pattern = "^[a-z0-9]+@[a-z0-9]+\\.ru\$".toRegex()
    return pattern.matches(email)
}

@Composable
fun sign_in3(GoToCreatepasword: () -> Unit){



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        UIKITstatusbar()
        Text(
            text = "Создание Профиля",
            fontSize = 24.sp,
            color = Color.Black,
            fontFamily = sfprobold,
            modifier = Modifier
                .padding(top = 50.dp, start = 20.dp)
        )
        Text(
            text = "Без профиля вы не сможете создавать проекты.",
            fontSize = 16.sp,
            color = Color(0xFF939396),
            fontFamily = sfproreg,
            modifier = Modifier
                .padding(top = 30.dp, start = 20.dp)
        )
        Text(
            text = "В профиле будут храниться результаты проектов и ваши описания.",
            fontSize = 16.sp,
            color = Color(0xFF939396),
            fontFamily = sfproreg,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp)
                .size(350.dp, 460.dp)
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    400,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Имя",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                )
            )
            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    400,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Отчество",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                    )
            )
            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    400,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Фамилия",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                    )
            )
            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    400,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Дата рождения",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                    )
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
                "Пол",
                sfproreg, 16,
                0xFF939396,
                icon = R.drawable.strl_vnis,
                iconCl = R.drawable.strl_vverh

            )
            )

            UIKIToutltextfield(
                item = TxtField(
                    text = remember { mutableStateOf("") },
                    400,
                    55,
                    0xFFF5F5F9,
                    10,
                    sfproreg,
                    15,
                    0xFF000000,
                    "Почта",
                    sfproreg,
                    15,
                    0xFFAEAEB2,
                    )
            )

        }

        UIKITbtn_main(item = Btn_main(
            width_btn = 350,
            height_btn = 60,
            color = 0xFF1A6FEE,
            colortext = 0xFFFFFFFF,
            label = "Далее",
            shape = 10,
            textsize = 18,
            font = sfprobold,
            padingtop = 50,
            padingstart = 20,
            enabled = true
        ), onClick = {GoToCreatepasword()}

        )


    }

}

@Composable
fun createpasword(GoToCreatepin: () -> Unit){
    var clickedp1 = remember { mutableStateOf<Boolean?>(true) }
    var clickedp2 = remember { mutableStateOf<Boolean?>(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

    ) {
        UIKITstatusbar()

        Row(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.1f)
        ) {
            Image(
                painter = painterResource(R.drawable.hello),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.2f)
            )

            Text(
                text = "Создание пароля!",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 28.sp
            )

        }
        Text(
            text = "Введите новый пароль",
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = sfproreg,
            modifier = Modifier
                .padding(start = 40.dp)
        )
        Column(modifier = Modifier
            .padding(start = 30.dp, top = 55.dp)
            .fillMaxWidth(0.9f)
            .height(200.dp),
        ) {
            Text(
                text = "Новый пароль",
                color = Color(0xFF7E7E9A),
                fontSize = 14.sp,
                fontFamily = sfproreg
            )

            OutlinedTextField(
                value = p1.value,
                onValueChange = {newText -> p1.value = newText},
                modifier = Modifier
                    .size(400.dp, 55.dp)
                    .background(Color(0xFFF5F5F9), RoundedCornerShape(10.dp)),
                textStyle = TextStyle(
                    color = Color(0xFF000000),
                    fontSize = 15.sp,
                    fontFamily = sfproreg
                ),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (clickedp1.value == false) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    Image(
                        painter = painterResource(if (clickedp1.value == true) R.drawable.gl_otkr else R.drawable.gl_zakr),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{
                                if (clickedp1.value == true) clickedp1.value = false else clickedp1.value = true
                            }
                    )
                }
            )

            Text(
                text = "Повторите пароль",
                color = Color(0xFF7E7E9A),
                fontSize = 14.sp,
                fontFamily = sfproreg,
                modifier = Modifier
                    .padding(top = 15.dp)
            )

            OutlinedTextField(
                value = p2.value,
                onValueChange = {newText -> p2.value = newText},
                modifier = Modifier
                    .size(400.dp, 55.dp)
                    .height(55.dp)
                    .background(Color(0xFFF5F5F9), RoundedCornerShape(12.dp)),
                textStyle = TextStyle(
                    color = Color(0xFF000000),
                    fontSize = 15.sp,
                    fontFamily = sfproreg
                ),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (clickedp2.value == false) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    Image(
                        painter = painterResource(if (clickedp2.value == true) R.drawable.gl_otkr else R.drawable.gl_zakr),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{
                                if (clickedp2.value == true) clickedp2.value = false else clickedp2.value = true
                            }
                    )
                }
            )


        }

        if  (p1.value != p2.value){
            Text(
                text = "Пароли не совпадают",
                color = Color(0xFFFF4646),
                fontFamily = sfprobold,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 120.dp)
            )
        }



        UIKITbtn_main(item = Btn_main(
            width_btn = 350,
            height_btn = 70,
            color = 0xFF1A6FEE,
            colortext = 0xFFFFFFFF,
            label = "Сохранить",
            shape = 10,
            textsize = 18,
            font = sfprobold,
            padingtop = 30,
            padingstart = 30,
            enabled = if (p1.value == p2.value && p1.value != "") true else false
        ))
        {
            GoToCreatepin()
        }

    }


}




@Composable
fun createpin(GoTo_main: () -> Unit){

    LaunchedEffect(counter) {
        if (counter == 4){
            delay(2000)
            GoTo_main()

            counter = 0
        }
    }

    UIKITstatusbar()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Создайте пароль",
            fontFamily = robotobold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 135.dp)
        )
        Text(
            text = "Для защиты ваших персональных данных",
            fontFamily = sfproreg,
            fontSize = 15.sp,
            color = Color(0xFF939396),
            modifier = Modifier
                .padding(top = 10.dp)
        )

        Row(modifier = Modifier
            .padding(top = 120.dp)
            .fillMaxHeight(0.035f)
            .fillMaxWidth(0.35f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = if (counter >= 1) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f)
            )
            Image(
                painter = if (counter >= 2) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.33f)
            )
            Image(
                painter = if (counter >= 3) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
            )
            Image(
                painter = if (counter == 4) painterResource(R.drawable.krug_zakr)  else painterResource(R.drawable.krug_pust),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
        }

        Column(modifier = Modifier
            .padding(top = 50.dp)
            .size(260.dp, 380.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"1", "1"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"2", "2"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF, "3", "3"))
            }
            //2
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF, "4", "4"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF, "5", "5"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,0xFFFFFFFF,"6", "6"))

            }
            //3
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"7", "7"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF,  0xFFFFFFFF,"8", "8"))
                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF,"9", "9"))

            }
            //4
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                LaunchedEffect(click) {
                    if (click != ""){
                        delay(200)
                        click = ""
                    }
                }

                Spacer(modifier = Modifier
                    .size(80.dp))

                UIKITbtn(item =  Btn(80, 80, 0xFFFFFFFF, 0xFFFFFFFF, "0", "0"))

                Button(
                    onClick = {
                        click = "10"
                        if (counter != 0) counter--
                    },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (click == "10") Color(0xFF1A6FEE) else Color(0xFFF5F5F9),
                    )

                ) {
                    Image(
                        painter = painterResource(R.drawable.del),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun main_(GoTo_main_katalog: () -> Unit,GoTo_main_proekt: () -> Unit,GoTo_main_profil: () -> Unit, GoTo_korzina: () -> Unit){
    var text = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.88f),

            ) {
            UIKITstatusbar()

            OutlinedTextField(
                value = text.value,
                {newText -> text.value = newText},
                modifier = Modifier
                    .padding(top = 20.dp, start = 25.dp)
                    .width(360.dp)
                    .height(50.dp)
                    .background(Color(0xFFEBEBEB), RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = sfproreg,
                    color = Color.Black

                ),
                leadingIcon = {
                    Image(
                        painter = painterResource( R.drawable.search),
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)

                    )

                },

                placeholder = {
                    Text(
                        text = "Искать описания",
                        style = TextStyle(
                            fontFamily = sfproreg,
                            fontSize = 16.sp,
                            color = Color(0xFF939396)
                        ),

                        )

                }
            )

            Text(
                text = "Акции и новости",
                color = Color(0xFF939396),
                fontFamily = sfprobold,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(start = 25.dp, top = 40.dp)
            )
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 15.dp, start = 25.dp)
                    .size(700.dp, 200.dp)

            ) {
                Row(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(0.45f)
                        .background(Color(0xFF92E9D4), RoundedCornerShape(12.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.4f)

                    ) {
                        Text(
                            text = "Шорты",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 15.dp, start = 15.dp)
                        )
                        Text(
                            text = "Вторник",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 15.dp)
                        )
                        Text(
                            text = "4000 ₽ ",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 70.dp, start = 15.dp)
                        )


                    }
                    Image(
                        painter = painterResource(R.drawable.banka),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp, start = 20.dp)
                            .fillMaxSize()

                    )
                }
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color(0xFF76B3FF), RoundedCornerShape(12.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.55f)

                    ) {
                        Text(
                            text = "Рубашка",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 15.dp, start = 15.dp)
                        )
                        Text(
                            text = "Воскресенье",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 15.dp)
                        )
                        Text(
                            text = "8000 ₽ ",
                            fontSize = 25.sp,
                            fontFamily = sfprobold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 70.dp, start = 15.dp)
                        )


                    }
                    Image(
                        painter = painterResource(R.drawable.man),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .fillMaxSize()

                    )
                }
            }

            Text(
                text = "Каталог описаний",
                color = Color(0xFF939396),
                fontFamily = sfprobold,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(start = 30.dp, top = 20.dp)
            )

            Row(
                modifier = Modifier
                    .padding(end = 25.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UIKITbtn_main(item = Btn_main (
                    width_btn = 80,
                    height_btn = 50,
                    label = "Все",
                    color = if (click_ == "Все") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Все") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 15,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 25,
                    enabled = true
                )) {
                    click_ = "Все"
                }

                UIKITbtn_main(item = Btn_main (
                    width_btn = 125,
                    height_btn = 50,
                    label = "Женщинам",
                    color = if (click_ == "Женщинам") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Женщинам") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 14,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 0,
                    enabled = true
                )) {
                    click_ = "Женщинам"
                }

                UIKITbtn_main(item = Btn_main (
                    width_btn = 125,
                    height_btn = 50,
                    label = "Мужчинам",
                    color = if (click_ == "Мужчинам") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Мужчинам") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 14,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 0,
                    enabled = true
                )) {
                    click_ = "Мужчинам"
                }


            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .weight(1f)

            ) {
                UIKITcard(
                    item = Cards(
                    340,
                    140,
                    20,
                    30,
                    0xFFF4F4F4,
                    12,
                    "Рубашка Воскресенье для машинного вязания",
                    0xFF000000,
                    16,
                    robotomed,
                    10,
                    10,
                    "Мужская одежда",
                    0xFF939396,
                    14,
                    robotobold,
                    20,
                    10,
                    "300 ₽",
                    0xFF000000,
                    17,
                    robotobold,
                    10,
                    10,
                    "Добавить",
                    0xFF2074F2,
                    0xFFFFFFFF,
                    14,
                    robotobold,
                    20,
                    30,
                    10,
                    0,
                    0,
                    0xFFFFFFFF,
                    45,
                    125,
                )){GoTo_korzina()}

                UIKITcard(item = Cards(
                    340,
                    140,
                    20,
                    30,
                    0xFFF4F4F4,
                    12,
                    "Рубашка Воскресенье для машинного вязания",
                    0xFF000000,
                    16,
                    robotomed,
                    10,
                    10,
                    "Мужская одежда",
                    0xFF939396,
                    14,
                    robotobold,
                    20,
                    10,
                    "300 ₽",
                    0xFF000000,
                    17,
                    robotobold,
                    10,
                    10,
                    "Добавить",
                    0xFF2074F2,
                    0xFFFFFFFF,
                    14,
                    robotobold,
                    20,
                    30,
                    10,
                    0,
                    0,
                    0xFFFFFFFF,
                    45,
                    125,
                )){}

            }






        }
        UIKITbotmBar({GoTo_main_katalog()},{},{GoTo_main_proekt()},{GoTo_main_profil()},)

    }
}

@Composable
fun main_katalog(GoTo_main: () -> Unit, GoTo_main_proekt: () -> Unit, GoTo_main_profil: () -> Unit, GoTo_korzina: () -> Unit){
    var btnvis by remember { mutableStateOf(false) }

    var text = remember { mutableStateOf("") }
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.88f)
        ) {
            UIKITstatusbar()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = text.value,
                    {newText -> text.value = newText},
                    modifier = Modifier
                        .padding(top = 20.dp, start = 25.dp)
                        .width(280.dp)
                        .height(50.dp)
                        .background(Color(0xFFEBEBEB), RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = sfproreg,
                        color = Color.Black

                    ),
                    leadingIcon = {
                        Image(
                            painter = painterResource( R.drawable.search),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)

                        )

                    },

                    placeholder = {
                        Text(
                            text = "Искать описания",
                            style = TextStyle(
                                fontFamily = sfproreg,
                                fontSize = 16.sp,
                                color = Color(0xFF939396)
                            ),

                            )

                    }
                )

                Image(
                    painter = painterResource(R.drawable.user_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 30.dp, top = 15.dp)
                        .size(40.dp)
                )

            }

            Row(
                modifier = Modifier
                    .padding(end = 25.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UIKITbtn_main(item = Btn_main (
                    width_btn = 80,
                    height_btn = 50,
                    label = "Все",
                    color = if (click_ == "Все") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Все") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 15,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 25,
                    enabled = true
                )) {
                    click_ = "Все"
                }

                UIKITbtn_main(item = Btn_main (
                    width_btn = 125,
                    height_btn = 50,
                    label = "Женщинам",
                    color = if (click_ == "Женщинам") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Женщинам") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 14,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 0,
                    enabled = true
                )) {
                    click_ = "Женщинам"
                }

                UIKITbtn_main(item = Btn_main (
                    width_btn = 125,
                    height_btn = 50,
                    label = "Мужчинам",
                    color = if (click_ == "Мужчинам") 0xFF1A6FEE else 0xFFF5F5F9,
                    colortext = if (click_ == "Мужчинам") 0xFFFFFFFF else 0xFF7E7E9A,
                    shape = 10,
                    textsize = 14,
                    font = robotobold,
                    padingtop = 15,
                    padingstart = 0,
                    enabled = true
                )) {
                    click_ = "Мужчинам"
                }


            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()

            ) {
                UIKITcard(
                    item = Cards(
                        340,
                        140,
                        20,
                        30,
                        0xFFF4F4F4,
                        12,
                        "Рубашка Воскресенье для машинного \n" +
                                "вязания",
                        0xFF000000,
                        16,
                        robotomed,
                        10,
                        10,
                        "Мужская одежда",
                        0xFF939396,
                        14,
                        robotobold,
                        20,
                        10,
                        "300 ₽",
                        0xFF000000,
                        17,
                        robotobold,
                        10,
                        10,
                        if (card1vis.value == false)"Добавить" else "Убрать",
                        if (card1vis.value == false) 0xFF2074F2 else 0xFFFFFFFF,
                        if (card1vis.value == false) 0xFFFFFFFF else 0xFF2074F2,
                        14,
                        robotobold,
                        20,
                        30,
                        10,
                        if (card1vis.value == false) 0 else 2,
                        if (card1vis.value == false) 0 else 10,
                        if (card1vis.value == false) 0xFFFFFFFF else 0xFF2074F2,
                        45,
                        125,
                    )
                ){if (card1vis.value == false) card1vis.value = true else card1vis.value = false}

                UIKITcard(
                    item = Cards(
                        340,
                        140,
                        20,
                        30,
                        0xFFF4F4F4,
                        12,
                        "Шорты вторник для машинного вязания",
                        0xFF000000,
                        16,
                        robotomed,
                        10,
                        10,
                        "Мужская одежда",
                        0xFF939396,
                        14,
                        robotobold,
                        20,
                        10,
                        "300 ₽",
                        0xFF000000,
                        17,
                        robotobold,
                        10,
                        10,
                        if (card2vis.value == false)"Добавить" else "Убрать",
                        if (card2vis.value == false) 0xFF2074F2 else 0xFFFFFFFF,
                        if (card2vis.value == false) 0xFFFFFFFF else 0xFF2074F2,
                        14,
                        robotobold,
                        20,
                        30,
                        10,
                        if (card2vis.value == false) 0 else 2,
                        if (card2vis.value == false) 0 else 10,
                        if (card2vis.value == false) 0xFFFFFFFF else 0xFF2074F2,
                        45,
                        125,
                    )
                ){if (card2vis.value == false) card2vis.value = true else card2vis.value = false}
            }

            if (card1vis.value || card2vis.value){
                Button(
                    onClick = {
                        GoTo_korzina()
                        if (card1vis.value == true || card2vis.value == true) summaAll.value = 300
                        if (card1vis.value == true && card2vis.value == true) summaAll.value = 600

                              },
                    modifier = Modifier
                        .padding(start = 25.dp, top = 60.dp)
                        .size(360.dp, 60.dp)
                        .background(Color(0xFF1A6FEE), RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A6FEE),
                        contentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.korz),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                        )
                        Text(
                            text = "В корзину",
                            fontFamily = sfprobold,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 20.dp)
                        )
                        Text(
                            text =  if (card1vis.value == true && card2vis.value == true) "600 ₽" else if (card1vis.value == true || card2vis.value == true) "300 ₽" else "0 ₽",
                            fontFamily = sfprobold,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 120.dp)
                        )
                    }
                }
            }



        }
        UIKITbotmBar({},{GoTo_main()},{GoTo_main_proekt()},{GoTo_main_profil()})
    }
}
@Composable
fun main_proekt(GoTo_main: () -> Unit, GoTo_main_profil: () -> Unit, GoTo_main_katalog: () -> Unit, GoTo_create_proekt: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.88f)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UIKITstatusbar()

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Проекты",
                    color = Color.Black,
                    fontFamily = robotobold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 140.dp)
                )
                Image(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 110.dp)
                        .clickable{
                            GoTo_create_proekt()

                        }
                        .size(30.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .size(350.dp, 140.dp)
                    .background(Color(0xFFF4F4F4), RoundedCornerShape(12.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.45f)
                ) {
                    Text(
                        text = "Мой первый проект",
                        color = Color.Black,
                        fontFamily = sfprobold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Прошло 2 дня",
                        color = Color(0xFF939396),
                        fontFamily = sfprobold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 40.dp)
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(start = 110.dp, top = 10.dp)
                            .size(110.dp, 40.dp)
                            .background(Color(0xFF1A6FEE), RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFF1A6FEE)
                        )
                    ) {
                        Text(
                            text = "Открыть",
                            fontSize = 14.sp,
                            fontFamily = sfprobold
                        )
                    }
                }
            }

        }
        UIKITbotmBar({GoTo_main_katalog()},{GoTo_main()},{},{GoTo_main_profil()})


    }

}
@Composable
fun main_profil(GoTo_main: () -> Unit, GoTo_main_proekt: () -> Unit, GoTo_main_katalog: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.88f)
                .background(Color.White)
        ) {
            UIKITstatusbar()

            Text(
                text = "Эдуард",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 25.dp, top = 50.dp)
            )

            Text(
                text = "afersfsr@dsfsr.ru",
                color = Color(0xFF939396),
                fontFamily = sfproreg,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 10.dp, start = 25.dp)
            )

            Row(
                modifier = Modifier
                    .padding(start = 25.dp, top = 30.dp)
                    .fillMaxWidth(0.85f)
                    .height(80.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.order),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(35.dp)

                )

                Text(
                    text = "Мои заказы",
                    color = Color.Black,
                    fontFamily = sfprobold,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(start = 25.dp, top = 27.dp)
                )

            }

            Row(
                modifier = Modifier
                    .padding(start = 25.dp)
                    .fillMaxWidth(0.85f)
                    .height(80.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(35.dp)

                )

                Text(
                    text = "Уведомления",
                    color = Color.Black,
                    fontFamily = sfprobold,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(start = 25.dp, top = 27.dp)
                )

                UIKITcheckBx()
            }


            Column(
                modifier = Modifier
                    .padding(start = 70.dp, top = 140.dp)
                    .size(260.dp, 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Политика конфиденциальности",
                    color = Color(0xFF939396),
                    fontSize = 16.sp,
                    fontFamily = sfprobold
                )
                Text(
                    text = "Пользовательское соглашение",
                    color = Color(0xFF939396),
                    fontSize = 16.sp,
                    fontFamily = sfprobold
                )
                Text(
                    text = "Выход",
                    color = Color(0xFFFD3535),
                    fontSize = 16.sp,
                    fontFamily = sfprobold
                )
            }
        }
        UIKITbotmBar({GoTo_main_katalog()},{GoTo_main()},{GoTo_main_proekt()},{})

    }

}
@Composable
fun create_proekt(GoTo_main_profil: () -> Unit,  GoTo_main: () -> Unit, GoTo_main_katalog: () -> Unit){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .height(1100.dp)
            .background(Color.White)
    ) {
        UIKITstatusbar()
        UIKITinputs_proekt()

        botmBar({GoTo_main_katalog()},{GoTo_main()},{},{GoTo_main_profil()})
    }

}
@Composable
fun korzina(GoTo_main_katalog: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        UIKITstatusbar()

        Button(
            onClick = {GoTo_main_katalog()},
            modifier = Modifier
                .padding(start = 25.dp, top = 35.dp)
                .background(Color(0xFFF5F5F9), RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF5F5F9),
                contentColor = Color(0xFF7E7E9A),
            )
        ) {
            Image(
                modifier = Modifier
                    .padding(2.dp)
                    .size(10.dp, 20.dp),
                painter = painterResource(R.drawable.strl_vvlevo),
                contentDescription = "",
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 25.dp, top = 35.dp)
                .fillMaxWidth()
                .height(50.dp)


        ) {
            Text(
                text = "Корзина",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 24.sp,
                modifier = Modifier

            )

            Image(
                painter = painterResource(R.drawable.delete),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 220.dp, top = 5.dp)
                    .size(25.dp)
                    .clickable{
                        card1vis.value = false
                        card2vis.value = false
                        summaAll.value = 0
                    }

            )
        }

        if (card1vis.value){
            UIKITcardKr(
                item = CardKR(
                    340,
                    140,
                    20,
                    30,
                    0xFFF4F4F4,
                    12,
                    "Рубашка воскресенье для машинного вязания",
                    0xFF000000,
                    16,
                    robotomed,
                    10,
                    10,
                    "1 штука",
                    0xFF000000,
                    14,
                    robotobold,
                    50,
                    115,
                    300,
                    0xFF000000,
                    17,
                    robotobold,
                    50,
                    10,

                    )
            )

        }
       if (card2vis.value){
           UIKITcardKr(
               item = CardKR(
                   340,
                   140,
                   40,
                   30,
                   0xFFF4F4F4,
                   12,
                   "Шорты вторник для машинного вязания",
                   0xFF000000,
                   16,
                   robotomed,
                   10,
                   10,
                   "1 штука",
                   0xFF000000,
                   14,
                   robotobold,
                   50,
                   115,
                   300,
                   0xFF000000,
                   17,
                   robotobold,
                   50,
                   10,

                   )
           )
       }


        Row(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Сумма",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 25.dp)

            )

            Text(
                text = "${summaAll.value} ₽",
                color = Color.Black,
                fontFamily = sfprobold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 210.dp)
            )
        }

        UIKITbtn_main(item = Btn_main (
            width_btn = 355,
            height_btn = 65,
            label = "Перейти к оформлению заказа",
            color = 0xFF1A6FEE,
            colortext = 0xFFFFFFFF,
            shape = 10,
            textsize = 17,
            font = robotobold,
            padingtop = 120,
            padingstart = 25,
            enabled = true
        )) {

        }


    }
}





