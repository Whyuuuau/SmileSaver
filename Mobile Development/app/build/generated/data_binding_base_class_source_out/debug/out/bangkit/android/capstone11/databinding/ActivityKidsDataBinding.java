// Generated by view binder compiler. Do not edit!
package bangkit.android.capstone11.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bangkit.android.capstone11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityKidsDataBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomBar;

  @NonNull
  public final ImageView btnBack;

  @NonNull
  public final Button btnCheckup;

  @NonNull
  public final Button btnHistory;

  @NonNull
  public final Button btnNearestDentist;

  @NonNull
  public final CardView cardKidsData;

  @NonNull
  public final ImageView ivAvatar;

  @NonNull
  public final View topBar;

  @NonNull
  public final TextView tvAddKids;

  @NonNull
  public final TextView tvKidsDataAge;

  @NonNull
  public final TextView tvKidsDataGender;

  @NonNull
  public final TextView tvKidsDataName;

  private ActivityKidsDataBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomBar, @NonNull ImageView btnBack,
      @NonNull Button btnCheckup, @NonNull Button btnHistory, @NonNull Button btnNearestDentist,
      @NonNull CardView cardKidsData, @NonNull ImageView ivAvatar, @NonNull View topBar,
      @NonNull TextView tvAddKids, @NonNull TextView tvKidsDataAge,
      @NonNull TextView tvKidsDataGender, @NonNull TextView tvKidsDataName) {
    this.rootView = rootView;
    this.bottomBar = bottomBar;
    this.btnBack = btnBack;
    this.btnCheckup = btnCheckup;
    this.btnHistory = btnHistory;
    this.btnNearestDentist = btnNearestDentist;
    this.cardKidsData = cardKidsData;
    this.ivAvatar = ivAvatar;
    this.topBar = topBar;
    this.tvAddKids = tvAddKids;
    this.tvKidsDataAge = tvKidsDataAge;
    this.tvKidsDataGender = tvKidsDataGender;
    this.tvKidsDataName = tvKidsDataName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityKidsDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityKidsDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_kids_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityKidsDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_bar;
      BottomNavigationView bottomBar = ViewBindings.findChildViewById(rootView, id);
      if (bottomBar == null) {
        break missingId;
      }

      id = R.id.btn_back;
      ImageView btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.btn_checkup;
      Button btnCheckup = ViewBindings.findChildViewById(rootView, id);
      if (btnCheckup == null) {
        break missingId;
      }

      id = R.id.btn_history;
      Button btnHistory = ViewBindings.findChildViewById(rootView, id);
      if (btnHistory == null) {
        break missingId;
      }

      id = R.id.btn_nearest_dentist;
      Button btnNearestDentist = ViewBindings.findChildViewById(rootView, id);
      if (btnNearestDentist == null) {
        break missingId;
      }

      id = R.id.card_kids_data;
      CardView cardKidsData = ViewBindings.findChildViewById(rootView, id);
      if (cardKidsData == null) {
        break missingId;
      }

      id = R.id.iv_avatar;
      ImageView ivAvatar = ViewBindings.findChildViewById(rootView, id);
      if (ivAvatar == null) {
        break missingId;
      }

      id = R.id.top_bar;
      View topBar = ViewBindings.findChildViewById(rootView, id);
      if (topBar == null) {
        break missingId;
      }

      id = R.id.tv_add_kids;
      TextView tvAddKids = ViewBindings.findChildViewById(rootView, id);
      if (tvAddKids == null) {
        break missingId;
      }

      id = R.id.tv_kids_data_age;
      TextView tvKidsDataAge = ViewBindings.findChildViewById(rootView, id);
      if (tvKidsDataAge == null) {
        break missingId;
      }

      id = R.id.tv_kids_data_gender;
      TextView tvKidsDataGender = ViewBindings.findChildViewById(rootView, id);
      if (tvKidsDataGender == null) {
        break missingId;
      }

      id = R.id.tv_kids_data_name;
      TextView tvKidsDataName = ViewBindings.findChildViewById(rootView, id);
      if (tvKidsDataName == null) {
        break missingId;
      }

      return new ActivityKidsDataBinding((ConstraintLayout) rootView, bottomBar, btnBack,
          btnCheckup, btnHistory, btnNearestDentist, cardKidsData, ivAvatar, topBar, tvAddKids,
          tvKidsDataAge, tvKidsDataGender, tvKidsDataName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
