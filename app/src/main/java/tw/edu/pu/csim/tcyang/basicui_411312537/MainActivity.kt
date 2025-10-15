package tw.edu.pu.csim.tcyang.basicui_411312537

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.tcyang.basicui_411312537.ui.theme.BasicUI411312537Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicUI411312537Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    // 總共有 5 個項目
    var Animals = listOf(R.drawable.pets, R.drawable.animal,
        R.drawable.kitty, R.drawable.happy,
        R.drawable.cat)

    var AnimalsName = arrayListOf("爪子","側面貓咪",
        "幼版貓咪","坐著的貓咪","趴著的貓咪")

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0x8aE0BBE4)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // 標題和作者資訊
        Text(
            text = stringResource(R.string.app_title),
            fontSize = 25.sp,
            color = Color.Blue,
            fontFamily = FontFamily(Font(R.font.kai))
        )
        Text(
            text = stringResource(R.string.app_author),
            fontSize = 20.sp,
            color = Color(0xFF654321)
        )

        Spacer(modifier = Modifier.size(10.dp))

        // 頂部圖片 Row
        Row {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Android icon",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow),
                alpha = 0.6f,
            )
            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "Compose icon",
                modifier = Modifier.size(100.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.firebase),
                contentDescription = "Firebase icon",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        // *** 修復閃退的 LazyRow，並重複 4 次 (5 * 4 = 20 個項目) ***
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            // items(20) 總共產生 20 個項目
            items(20) { index ->
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 4.dp)) {

                    // 使用 index % 5 確保索引在 [0, 4] 之間循環，避免閃退
                    Text(text = AnimalsName[index % 5])

                    // 顯示目前的索引編號
                    Text(text = "$index")

                    Image(
                        // 使用 index % 5 確保索引在 [0, 4] 之間循環，避免閃退
                        painter = painterResource(id = Animals[index % 5]),
                        contentDescription = "可愛動物圖片",
                        modifier = Modifier.size(60.dp)
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
        // **********************************************

        Spacer(modifier = Modifier.size(10.dp))

        // 此處不再有 0-51 的數字列表

    } // Column 結束
}

// 預覽功能 (Preview)
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    BasicUI411312537Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Main(modifier = Modifier.padding(innerPadding))
        }
    }
}


