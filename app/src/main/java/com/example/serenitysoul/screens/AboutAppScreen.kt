package com.example.serenitysoul.screens

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.serenitysoul.R
import com.example.serenitysoul.navigation.Screen

@Composable
fun AboutAppScreen(
    textId: Int,
    //onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    //val s = argument.getString("")
    Column {
        Text(text = stringResource(id = textId))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {onCancelButtonClicked.invoke("987")}
            ) {
                Text(stringResource(R.string.cancel))
            }
            /*Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //enabled = selectedValue.isNotEmpty(),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.next))
            }*/
        }
    }
}

@Preview(
    showBackground = false, backgroundColor = 0xFF606981,
    device = "spec:parent=pixel_5", showSystemUi = true
)
@Composable
fun previewAboutAppScreen() {
    AboutAppScreen(
        textId = Screen.AboutAppScreen.titleResId,
        onCancelButtonClicked = {},
    )
}