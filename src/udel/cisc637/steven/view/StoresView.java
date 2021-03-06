package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import app.start.Start;

import udel.cisc637.steven.controller.StoresViewController;
import udel.cisc637.steven.dao.StoresDao;
import udel.cisc637.steven.model.StoresModel;

public class StoresView {
	public void displayAllStores(int items, int page) {

		// TODO Auto-generated method stub
		StoresDao StoresController = new StoresDao();
		List<StoresModel> storesList= StoresController.getAllStores(items,page);
		System.out.print("\n");
		System.out.println("===Stores===");
		for(StoresModel e:storesList){
			System.out.println(e.getStoreName());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		int options=0;
		
		if(!Start.Admin&&Start.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Store by StoreName.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			options=5;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresView(choice);
		}
		
		if(!Start.Admin&&Start.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Store by StoreName.");
			System.out.println("3. Go Back.");
			System.out.println("4. Quit");
			options=4;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresView(choice);
		}
		
		if(Start.Admin&&Start.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Store by StoreName.");
			System.out.println("4. Add.");
			System.out.println("5. Delete.");
			System.out.println("6. Update.");
			System.out.println("7. Go Back.");
			System.out.println("8. Quit");
			options=8;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresViewAdmin(choice);
		}
		
		if(Start.Admin&&Start.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Store by StoreName.");
			System.out.println("3. Add.");
			System.out.println("4. Delete.");
			System.out.println("5. Update.");
			System.out.println("6. Go Back.");
			System.out.println("7. Quit");
			options=7;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresViewAdmin(choice);
		}
	}
	
	public void displayStoreFromStoreName(String StoreName) {
		
	    	if(StoreName==null){
				MainMenuView mainMenuView = new MainMenuView();
				StoreName=mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
			}
	    	
	    	StoresDao storesDao = new StoresDao();
			StoresModel store= storesDao.getStore(StoreName);
			System.out.print("\n");
			System.out.println("===Store===");
			System.out.println("Store Name: "+store.getStoreName());
			System.out.println("Url: "+store.getStoreLink());
			System.out.println("===========");
			System.out.print("\n");
			
			if(Start.Admin){
				System.out.println("===Menu===");
				System.out.println("1. delete");
				System.out.println("2. update");
				System.out.println("3. See Products Under A Store");
				System.out.println("4. Go Back.");
				System.out.println("5. Quit");
				Start.setStoreName(StoreName);

				int options=5;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreViewAdmin(choice);
			}else if(Start.login){
				System.out.println("===Menu===");
				System.out.println("1. Add store to favorites");
				System.out.println("2. See Products Under A Store");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				Start.setStoreName(StoreName);
				
				int options=4;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreViewUser(choice);
			}else{
				System.out.println("===Menu===");
				System.out.println("1. See Products Under A Store");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				Start.setStoreName(StoreName);

				int options=3;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreView(choice);
			}
	}
}
