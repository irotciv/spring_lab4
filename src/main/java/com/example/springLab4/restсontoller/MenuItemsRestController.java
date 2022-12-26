package com.example.springLab4.restсontoller;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.service.MenuItemsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "OpenAPI Documentation",
                description = "Documentation of RESTful webservice in Lab4",
                version = "v.1.0.0"
        )
)

@Tag(
        name = "Menu Items",
        description = "Operation with menu items"
)

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemsRestController {
    private final MenuItemsService menuItemsService;

    public MenuItemsRestController(MenuItemsService menuItemsService) {
        this.menuItemsService = menuItemsService;
    }

    @Operation(
            summary = "Get menu items by parameters",
            description = "Get menu items by parameters (price of menu item, part of menu item's description)"
    )
    @Parameter(name = "price", description = "Price of the menu item")
    @Parameter(name = "description", description = "A part of menu item's description")
    @Parameter(name = "page", description = "A page with menu items ")
    @Parameter(name = "size", description = "A size of menu items on page")
    @ApiResponse(responseCode = "200", description = "Successful menu items search")
    @ApiResponse(responseCode = "404", description = "The menu items are not found", content = @Content)
    @GetMapping()
    public List<MenuItems> getMenuItems(@RequestParam(required = false) Integer price,
                                        @RequestParam(required = false) String description,
                                        @Valid @Min(0) @RequestParam(required = false, defaultValue = "0") Integer page,
                                        @Valid @Min(1) @RequestParam(required = false, defaultValue = "2")  Integer size) {
        return menuItemsService.findPaginated(price, description, page, size);
    }

    @Operation(
            summary = "Add new menu item",
            description = "Add menu item to collection"
    )
//    @Parameter(name = "menuItem", description = "New menu item")
    @Parameter(in = ParameterIn.QUERY, name = "name", description = "Name of new menu item", required = true)
    @Parameter(in = ParameterIn.QUERY, name = "description", description = "Description of new menu item", required = true)
    @Parameter(in = ParameterIn.QUERY, name = "price", description = "Price of new menu item", required = true)
    @ApiResponse(responseCode = "200", description = "Successful menu items creating")
    @ApiResponse(responseCode = "404", description = "The menu items are not valid", content = @Content)
    @PostMapping()
    ResponseEntity<?> createNewMenuItem(@Valid MenuItems menuItem) {
        MenuItems newMenuItem = menuItemsService.addNewMenuItem(menuItem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newMenuItem.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(
            summary = "Get menu item",
            description = "Get the menu item by ID"
    )
    @Parameter(name = "id", description = "The menu item's ID")
    @ApiResponse(responseCode = "200", description = "Successful menu item's getting")
    @ApiResponse(responseCode = "404", description = "The menu item is not found", content = @Content)
    @GetMapping("/{id}")
    ResponseEntity<MenuItems> getMenuItem(@PathVariable Long id) {
        MenuItems menuItem = menuItemsService.getMenuItemById(id);
        if (menuItem == null) {
            throw new MenuItemNotFoundException(id);
//            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menuItem);
    }

    @Operation(
            summary = "Update the menu item",
            description = "Update the information about a menu item by ID"
    )
    @Parameter(in = ParameterIn.QUERY, name = "name", description = "Name of new menu item", required = true)
    @Parameter(in = ParameterIn.QUERY, name = "description", description = "Description of new menu item", required = true)
    @Parameter(in = ParameterIn.QUERY, name = "price", description = "Price of new menu item", required = true)
    @Parameter(name = "id", description = "The menu item's ID")
    @ApiResponse(responseCode = "200", description = "Successful menu items updating")
    @ApiResponse(responseCode = "404", description = "The menu item is not valid", content = @Content)
    @PutMapping("/{id}")
    ResponseEntity<MenuItems> updateMenuItem(@PathVariable Long id, @Valid MenuItems menuItem) {
        MenuItems oldMenuItem = menuItemsService.getMenuItemById(id);
        if (oldMenuItem == null) {
            throw new MenuItemNotFoundException(id);
//            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menuItemsService.updateMenuItem(oldMenuItem, menuItem));
    }

    @Operation(
            summary = "Delete the menu item",
            description = "Delete the menu item from collection"
    )
    @Parameter(name = "id", description = "The menu item's ID")
    @ApiResponse(responseCode = "200", description = "Successful menu item's deleting")
    @ApiResponse(responseCode = "404", description = "The menu item is not found", content = @Content)
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        MenuItems menuItem = menuItemsService.getMenuItemById(id);
        if (menuItem == null) {
            throw new MenuItemNotFoundException(id);
//            return ResponseEntity.notFound().build();
        }
        menuItemsService.deleteMenuItem(menuItem);
        return ResponseEntity.ok().build();
    }
}
