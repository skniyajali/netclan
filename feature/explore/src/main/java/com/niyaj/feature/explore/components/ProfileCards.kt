package com.niyaj.feature.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.niyaj.common.utils.toDividerText
import com.niyaj.designsystem.theme.IconSizeMedium
import com.niyaj.designsystem.theme.IconSizeSmall
import com.niyaj.designsystem.theme.ProfilePictureSizeMedium
import com.niyaj.designsystem.theme.ProfilePictureSizeSmall
import com.niyaj.designsystem.theme.SpaceLarge
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.designsystem.theme.SpaceSmall
import com.niyaj.designsystem.theme.SpaceSmallMax
import com.niyaj.model.BusinessProfile
import com.niyaj.model.MerchantProfile
import com.niyaj.model.PersonalProfile

@Composable
fun PersonalProfileCard(
    profile: PersonalProfile,
    onClickInvite: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = ProfilePictureSizeSmall, end = SpaceSmall)
            .drawBehind {
                drawRoundRect(
                    Color.White,
                    cornerRadius = CornerRadius(50f, 50f),
                    blendMode = BlendMode.Hardlight
                )
            }
            .shadow(
                3.dp,
                RoundedCornerShape(50f),
                clip = false,
                ambientColor = Color.Gray
            )
            .background(Color.White, RoundedCornerShape(50f)),
        verticalArrangement = Arrangement.spacedBy(SpaceSmall),
    ) {
        Text(
            text = "+ INVITE",
            modifier = Modifier
                .align(Alignment.End)
                .padding(SpaceMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    onClickInvite()
                }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = SpaceMedium),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp, 80.dp)
                    .offset(
                        x = -ProfilePictureSizeSmall,
                        y = -SpaceMedium
                    )
                    .background(
                        MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(SpaceSmallMax)
                    )
            ) {
                Text(
                    text = profile.firstName.take(1).uppercase(),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
            }

            Column(
                modifier = Modifier.offset(x = -SpaceLarge),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(SpaceSmall),
            ) {
                Text(
                    text = "${profile.firstName} ${profile.lastName}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "${profile.profession} | ${profile.city}",
                    style = MaterialTheme.typography.overline,
                )

                Text(
                    text = "Within ${profile.locationRange}",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold
                )

                LinearProgressIndicator(
                    progress = profile.profileCompletionStatus,
                    backgroundColor = MaterialTheme.colors.secondaryVariant,
                    color = MaterialTheme.colors.primaryVariant,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier
                        .width(100.dp)
                        .height(10.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceMedium),
            verticalArrangement = Arrangement.spacedBy(SpaceSmall)
        ) {
            val dividerText = profile.userPurpose.map { it.name }.toDividerText()

            Text(
                text = dividerText,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = profile.userStatus,
                style = MaterialTheme.typography.overline,
            )
        }
    }
}


@Composable
fun BusinessProfileCard(
    profile: BusinessProfile,
    onPhoneClick: (String) -> Unit,
    onContactClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = ProfilePictureSizeSmall, end = SpaceSmall)
            .drawBehind {
                drawRoundRect(
                    Color.White,
                    cornerRadius = CornerRadius(50f, 50f),
                )
            }
            .shadow(
                2.dp,
                RoundedCornerShape(50f),
                clip = false,
            )
            .background(Color.White, RoundedCornerShape(50f)),
        verticalArrangement = Arrangement.spacedBy(SpaceSmall),
    ) {
        Spacer(modifier = Modifier.height(SpaceLarge))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = SpaceMedium),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(ProfilePictureSizeMedium)
                    .offset(
                        x = -ProfilePictureSizeSmall,
                        y = -SpaceMedium
                    )
                    .background(
                        MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(SpaceSmall)
                    )
            ) {
                Text(
                    text = profile.firstName.take(1).uppercase() + profile.lastName.take(1)
                        .uppercase(),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Column(
                modifier = Modifier.offset(x = -SpaceLarge),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(SpaceSmall),
            ) {
                Text(
                    text = "${profile.firstName} ${profile.lastName}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "${profile.profession} | ${profile.city}",
                    style = MaterialTheme.typography.overline,
                )

                LinearProgressIndicator(
                    progress = profile.profileStatus,
                    backgroundColor = MaterialTheme.colors.secondaryVariant,
                    color = MaterialTheme.colors.primaryVariant,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier
                        .width(100.dp)
                        .height(10.dp)
                )

                Row(
                    modifier = Modifier
                        .width(70.dp)
                        .align(Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        SpaceMedium,
                        Alignment.CenterHorizontally
                    )
                ) {
                    IconButton(
                        onClick = {
                            onPhoneClick(profile.profileId)
                        },
                        modifier = Modifier
                            .background(MaterialTheme.colors.primary, CircleShape)
                            .size(IconSizeMedium)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone Icon",
                            tint = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.size(IconSizeSmall)
                        )
                    }

                    IconButton(
                        onClick = {
                            onContactClick(profile.profileId)
                        },
                        modifier = Modifier
                            .background(MaterialTheme.colors.primary, CircleShape)
                            .size(IconSizeMedium)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PersonPin,
                            contentDescription = "Contacts Icon",
                            tint = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.size(IconSizeSmall)
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceMedium),
            verticalArrangement = Arrangement.spacedBy(SpaceSmall)
        ) {
            Text(
                text = "${profile.profession} | ${profile.yearsOfExperience} years of experience",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = profile.userStatus,
                style = MaterialTheme.typography.overline,
            )
        }
    }
}

@Composable
fun MerchantProfileCard(
    profile: MerchantProfile,
    onPhoneClick: (String) -> Unit,
    onLocationClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = ProfilePictureSizeSmall, end = SpaceSmall)
            .drawBehind {
                drawRoundRect(
                    Color.White,
                    cornerRadius = CornerRadius(50f, 50f),
                )
            }
            .shadow(
                2.dp,
                RoundedCornerShape(50f),
                clip = false,
            )
            .background(Color.White, RoundedCornerShape(50f)),
        verticalArrangement = Arrangement.spacedBy(SpaceSmall),
    ) {
        Spacer(modifier = Modifier.height(SpaceLarge))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = SpaceMedium),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(ProfilePictureSizeMedium)
                    .offset(
                        x = -ProfilePictureSizeSmall,
                        y = -SpaceMedium
                    )
                    .background(
                        MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(SpaceSmall)
                    )
            ) {
                Text(
                    text = profile.merchantName.take(1).uppercase(),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.primary
                )
            }

            Column(
                modifier = Modifier.offset(x = -SpaceLarge),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(SpaceSmall),
            ) {
                Text(
                    text = profile.merchantName,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "${profile.city}, within ${profile.locationRange}",
                    style = MaterialTheme.typography.overline,
                )

                LinearProgressIndicator(
                    progress = profile.profileStatus,
                    backgroundColor = MaterialTheme.colors.secondaryVariant,
                    color = MaterialTheme.colors.primaryVariant,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier
                        .width(130.dp)
                        .height(10.dp)
                )

                Row(
                    modifier = Modifier
                        .width(130.dp)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        SpaceMedium,
                        Alignment.CenterHorizontally
                    )
                ) {
                    IconButton(
                        onClick = {
                            onPhoneClick(profile.merchantId)
                        },
                        modifier = Modifier
                            .background(MaterialTheme.colors.primary, CircleShape)
                            .size(IconSizeMedium)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone Icon",
                            tint = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.size(IconSizeSmall)
                        )
                    }

                    IconButton(
                        onClick = {
                            onLocationClick(profile.merchantId)
                        },
                        modifier = Modifier
                            .background(MaterialTheme.colors.primary, CircleShape)
                            .size(IconSizeMedium)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Phone Icon",
                            tint = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.size(IconSizeSmall)
                        )
                    }
                }
            }
        }

        Text(
            text = profile.merchantStatus,
            style = MaterialTheme.typography.overline,
            modifier = Modifier.padding(SpaceMedium)
        )
    }
}