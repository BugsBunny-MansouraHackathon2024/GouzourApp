import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.bugsbunny.gouzour.R

@Composable
fun HomeScreen(navController: NavController) {
    var productList by remember { mutableStateOf(sampleProducts()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Top Bar
        TopAppBar()

        // Banner
        BannerSection()

        // Latest Orders Section
        LatestOrdersSection(
            productList = productList,
            onAddMoreClick = { productList = productList + generateNewProduct() }
        )

        // Bottom Navigation
        BottomNavigationBar()
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        Text(
            text = "مرحباً بعودتك",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
    }
}

@Composable
fun BannerSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Left side with image
//            Image(
//                painter = painterResource(id = R.drawable.farmer_banner), // Replace with your image
//                contentDescription = null,
//                modifier = Modifier.size(100.dp)
//            )

            // Right side with button
            Button(
                onClick = { /* Show Products */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000))
            ) {
                Text(text = "عرض منتجاتي")
            }
        }
    }
}

@Composable
fun LatestOrdersSection(
    productList: List<Product>,
    onAddMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "أحدث الطلبات",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Product cards
        Column {
            productList.forEach { product ->
                ProductCard(product = product)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Add More button
        Button(
            onClick = onAddMoreClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8BC34A))
        ) {
            Text(text = "إضافة المزيد")
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product Image
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Product Details
            Column {
                Text(text = "اسم المنتج: ${product.name}", style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "الكمية: ${product.quantity} كيلو")
                Text(text = "العنوان: ${product.address}")
                Text(text = "السعر: ${product.price} جنيه")
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        content = {
            // Bottom navigation items (icons and labels)
            IconButton(onClick = { /* Home clicked */ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { /* Cart clicked */ }) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { /* Profile clicked */ }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
            }
        }
    )
}

// Sample Data and Helper Functions
data class Product(
    val name: String,
    val quantity: Int,
    val address: String,
    val price: Double,
    val imageRes: Int
)

fun sampleProducts(): List<Product> {
    return listOf(
        Product("خيار", 50, "المنصورة شارع أحمد ماهر", 200.0, R.drawable.cucumber),
        Product("طماطم", 50, "المنصورة شارع أحمد ماهر", 400.0, R.drawable.tomato),
        Product("ثوم", 100, "المنصورة شارع أحمد ماهر", 500.0, R.drawable.garlic),
        Product("باذنجان", 75, "المنصورة شارع أحمد ماهر", 350.0, R.drawable.eggplant)
    )
}

fun generateNewProduct(): Product {
    return Product(
        "منتج جديد",
        (10..100).random(),
        "المنصورة شارع أحمد ماهر",
        (100..500).random().toDouble(),
        R.drawable.garlic
    )
}