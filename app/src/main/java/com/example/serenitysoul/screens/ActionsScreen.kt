package com.example.serenitysoul.screens

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
fun ActionScreen(
    textId: Int,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = stringResource(id = textId))
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
        }
    }
}

@Preview(
    showBackground = false, backgroundColor = 0xFF606981,
    device = "spec:parent=pixel_5", showSystemUi = true
)
@Composable
fun previewActionScreen() {
    ActionScreen(
        textId = Screen.ActionsScreen.titleResId,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
    )
}