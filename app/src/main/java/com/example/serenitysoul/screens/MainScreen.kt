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
fun MainScreen(
    textId: Int,
    onSettingsDestination: (String) -> Unit,
    onActionsDestination: () -> Unit,
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
            Button(
                modifier = modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //enabled = selectedValue.isNotEmpty(),
                onClick = {onSettingsDestination.invoke("123")}
            ) {
                Text(stringResource(R.string.settings))
            }
            Button(
                modifier = modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //enabled = selectedValue.isNotEmpty(),
                onClick = onActionsDestination
            ) {
                Text(stringResource(R.string.action))
            }
        }
    }
}

@Preview(
    showBackground = false, backgroundColor = 0xFF606981,
    device = "spec:parent=pixel_5", showSystemUi = true
)
@Composable
fun previewMainScreen() {
    MainScreen(
        textId = Screen.MainScreen.titleResId,
        onSettingsDestination = {},
        onActionsDestination = {},
        onCancelButtonClicked = {},
    )
}